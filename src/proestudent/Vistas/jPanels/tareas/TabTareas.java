package proestudent.Vistas.jPanels.tareas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import proestudent.Conexion;
import proestudent.ProEstudent;
import proestudent.Vistas.jPanels.notas.ContenedorNotas;
import proestudent.clases.Materia;
import proestudent.clases.Profesor;
import proestudent.clases.Tareas;


public class TabTareas extends javax.swing.JPanel {
    private  static LinkedList <Materia> listaMateria;
    private  static LinkedList <Profesor> listaProfesores;
    
    private ContenedorTareas container;
    private LinkedList <ContenedorTareas>listaContenedores;
    public TabTareas() {
        initComponents();
        container = new ContenedorTareas(this);
        listaContenedores= new <ContenedorNotas> LinkedList();
        listaMateria = new <Materia> LinkedList();
        listaProfesores = new <Profesor> LinkedList ();
        Tareas.insertarContenedorTarea(jTabbedPane, container);
        listaContenedores.addLast(container);
        
        this.cargarProfesores();
        this.cargarMaterias();
        this.cargarTareas();
    }
     public void crearContenedor(){
        JTabbedPane jTabbedP = new JTabbedPane();
        ContenedorTareas contenedorTareas= new ContenedorTareas(this);
        jTabbedP.add(contenedorTareas);
        Tareas.insertarContenedorTarea(jTabbedPane, contenedorTareas, "");
        contenedorTareas.setVisibleEliminarContenedor(true);
        listaContenedores.addLast(contenedorTareas);
    }
    public  void actualizarTareas(){
        for (ContenedorTareas contenedor : listaContenedores) {
            for (Tarea tarea : contenedor.getArrTareas()) {
                if(tarea!=null){
                    tarea.setDatosDeMateria(tarea.getMateria());
                }
            }
        }
    }
    public void recolectarMaterias(Profesor profesor){
        LinkedList  <Materia> list= new <Materia> LinkedList();
        for (Materia materia:TabTareas.getListaMateria()) {
            if (materia.getProfesor().equals(profesor)) {
                this.recolectarTareas(materia);
                list.addLast(materia);
            }
        }
        for (Materia materia : list){
            TabTareas.getListaMateria().remove(materia);
        }
        list.clear();
    }
    /*
    * Las tareas que no tengan materia seran eliminadas.
    */
    public void recolectarTareas(Materia materia){
       
       for (ContenedorTareas contenedor : listaContenedores) {
            for (Tarea tarea : contenedor.getArrTareas()) {
                //Se elimina tarea si existe y si no tiene materia.
                if (  tarea!= null && tarea.getMateria().equals(materia) ){
                        Tareas.destruir(tarea, contenedor);
                        contenedor.updateUI();
                        System.out.println("Tarea destruida");
                }
            }
        }
    }
    public int buscarProfesorPorId(int id){
        int posicion=0;
        for(Profesor profesor: TabTareas.getListaProfesores()){
            if(profesor.getId()==id){
                break;
            }
            posicion ++;
        }
        return posicion;
    }
    public int buscarMateriaPorId(int id){
        int posicion=0;
        for(Materia materia: TabTareas.getListaMateria()){
            if(materia.getId()==id){
                break;
            }
            posicion ++;
        }
        return posicion;
    }
    public final void cargarTareas(){
           Conexion conexionNota = new Conexion();
          int contenedor=0;
          int n=0;
        try {
                    String titulo;
                    String contenido;
                    Statement st = conexionNota.getConexion().createStatement();
                    ResultSet set =st.executeQuery("select t.titulo, t.contenido, t.diafinalizacion, t.materia from \n"
                                                   +"profesor as p , materia as m, tareas as t\n"
                                                   +"where p.id = m.profesor and m.id = t.materia and p.usuario = "+ ProEstudent.USUARIO);
                        while(set.next()){
                            if (n==6){
                                this.crearContenedor();
                                contenedor++;
                                n=0;
                            }
                            titulo=set.getString("titulo");
                            contenido = set.getString("contenido");
                            if(set.getInt("materia")!=0){
                                Tarea tarea = new Tarea(this.getListaContenedores(contenedor).getArrPaneles()[n],this.getListaContenedores(contenedor));
                                tarea.setDatosDeMateria(TabTareas.getListaMateria().get(this.buscarMateriaPorId(set.getInt("materia"))));
                                tarea.setFecha(set.getString("diaFinalizacion"));
                                tarea.setTitulo(titulo);
                                tarea.setContenido(contenido);
                                
                                Tareas.insertarNota(tarea.getContenedor().getArrPaneles()[tarea.getPosicion()],tarea,tarea.getContenedor());
                                tarea.mostrarColorEnDiasFaltantes(tarea.obtenerDiasFaltantes(tarea.getFecha()));
                            }
                            n++;
                        }
          set.close();
          st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProEstudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public final void cargarMaterias(){
         Conexion conexionNota = new Conexion();
        try {   
                Statement st = conexionNota.getConexion().createStatement();
                ResultSet set =st.executeQuery("select m.id,m.nombre,m.profesor,m.prioridad from materia as m, profesor as p where p.id = m.profesor and p.usuario ="+ProEstudent.USUARIO );
                while(set.next()){
                      Materia materia= new Materia (TabTareas.getListaProfesores().get(this.buscarProfesorPorId(set.getInt("profesor"))),set.getString("nombre"),set.getInt("prioridad"));
                      materia.setId(set.getInt("id"));
                      TabTareas.getListaMateria().addLast(materia);
                }
                set.close();
                st.close();
        } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public final void cargarProfesores(){
        Conexion conexionNota = new Conexion();
        try {   
                Statement st = conexionNota.getConexion().createStatement();
                ResultSet set =st.executeQuery("select * from profesor where usuario=" + ProEstudent.USUARIO);
                while(set.next()){
                    Profesor profesor = new Profesor(set.getString("nombre"));
                    profesor.setId(set.getInt("id"));
                    TabTareas.getListaProfesores().add(profesor);
            }
                set.close();
                st.close();
        } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public int buscarIdMateria(Materia materia){
         Conexion conexion = new Conexion();
         //Valor en caso de que no exista base de datos
         int id=TabTareas.getListaProfesores().size()+1;
        try {
            
            Statement st = conexion.getConexion().createStatement();
            ResultSet set =st.executeQuery("SELECT * FROM materia where profesor = "+ materia.getProfesor().getId());
            while(set.next()){
                if(materia.getNombreMateria().equals(set.getString("nombre"))){
                    id = set.getInt("id");
                    break;
                }
            }
            set.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TabTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
     }
     public int colocarIdProfesor(Profesor profesor){
         Conexion conexion = new Conexion();
         //Valor en caso de que no exista base de datos
         int id=TabTareas.getListaProfesores().size()+1;
        try {
            
            Statement st = conexion.getConexion().createStatement();
            ResultSet set =st.executeQuery("SELECT * FROM profesor where usuario = "+ProEstudent.USUARIO);
            while(set.next()){
                if(profesor.getNombre().equals(set.getString("nombre"))){
                   id=set.getInt("id");
                   break;
                } 
            }
            set.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TabTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
     }
 
    public void eliminarContenedor(ContenedorTareas contenedor){
        for (int i = 0; i <this.getListaContenedores().size(); i++) {
            if(this.getListaContenedores().get(i).equals(contenedor)){
                this.getListaContenedores().remove(i);
                break;
            }
        }  
                jTabbedPane.remove(contenedor);
                jTabbedPane.updateUI();
                this.updateUI();
                System.out.println(this.getListaContenedores().size());
    }

    public static LinkedList<Materia> getListaMateria() {
        return listaMateria;
    }

    public static void setListaMateria(LinkedList<Materia> listaMateria) {
        TabTareas.listaMateria = listaMateria;
    }
    public static LinkedList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public static void setListaProfesores(LinkedList<Profesor> listaProfesores) {
        TabTareas.listaProfesores = listaProfesores;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();

        jTabbedPane.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public ContenedorTareas getListaContenedores(int i) {
        return listaContenedores.get(i);
    }
    public LinkedList<ContenedorTareas> getListaContenedores() {
        return listaContenedores;
    }
    public void setListaContenedores(LinkedList<ContenedorTareas> listaContenedores) {
        this.listaContenedores = listaContenedores;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
