
package proestudent.Vistas.jPanels.proyectos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proestudent.Conexion;
import proestudent.ProEstudent;
import proestudent.Vistas.jFrames.Principal;
import proestudent.clases.Proyectos;
import proestudent.clases.TareaProyecto;

public class TabProyectos extends javax.swing.JPanel {
    private Principal principal;
    private LinkedList <Proyecto> listaProyectos;
    public TabProyectos(Principal principal) {
        initComponents();
        this.principal=principal;
        this.listaProyectos=new LinkedList();
        //Carga proyectos de la base de datos
        this.cargarProyectos();
        this.cargarTareasProyecto();
    }
    public final void cargarTareasProyecto(){
            Conexion conexionNota = new Conexion();
            String tarea;
            String descripcion;
            int columna;
          try {   
                Statement st = conexionNota.getConexion().createStatement();
                for(Proyecto proyecto : listaProyectos){
                    ResultSet set =st.executeQuery("SELECT * FROM TareaProyecto WHERE proyecto ="+ proyecto.getId());
                     while(set.next()){
                         columna = set.getInt("columna");
                         tarea = set.getString("tarea");
                         descripcion = set.getString("descripcion");
                         TareaProyecto tareaP = proyecto.crearTarea(columna);
                         tareaP.setTarea(tarea);
                         tareaP.setDescripción(descripcion);
                         tareaP.setColumna(columna);
                         proyecto.agregarTarea(columna, tareaP);
                    }
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public final void cargarProyectos(){
            Conexion conexionNota = new Conexion();
            String nombre;
            int id;
        try {   
                Statement st = conexionNota.getConexion().createStatement();
                ResultSet set =st.executeQuery("SELECT id, nombre FROM Proyecto WHERE usuario ="+ProEstudent.USUARIO);
                while(set.next()){
                    nombre=set.getString("nombre");
                    id = set.getInt("id");
                    this.cargarProyecto(nombre,id);
                    System.out.println("Proyecto creado con id"+ id);
                }
                
                set.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public int buscarIdProyecto(Proyecto proyecto){
        //Valor en caso de que no exista base de datos
        int id=listaProyectos.size()+1;
        Conexion connetion = new Conexion();
        try {
                Statement st = connetion.getConexion().createStatement();
                ResultSet set =st.executeQuery("SELECT * FROM proyecto WHERE usuario ="+ ProEstudent.USUARIO);
                while(set.next()){
                    if(proyecto.getNombreProyecto().equals(set.getString("nombre"))){
                        id=set.getInt("id");
                    }
                }
                set.close();
                st.close();

            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return id;
    }
    
    public void eliminarProyecto(Proyecto proyect){
        int opcion=JOptionPane.showConfirmDialog(null, "¿Desea eliminar el proyecto?", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(opcion==0){    
            this.jTabbedPane1.remove(proyect);
            this.updateUI();

            this.principal.setnProyectos(principal.getnProyectos()-1);
            listaProyectos.remove(proyect);
        }
    }
    public void cargarProyecto(String nombreProyecto, int id){
           Proyecto proyecto = new Proyecto(this, id);
           proyecto.setNombreProyecto(nombreProyecto);
           Proyectos.insertarProyecto(jTabbedPane1, proyecto);
           listaProyectos.addLast(proyecto);
           
           this.principal.setnProyectos(principal.getnProyectos()+1);
    }
    public boolean crearNuevoProyecto(){
     try{
        String nombreProyecto = JOptionPane.showInputDialog(this, "Ingrese el nombre del proyecto","Nuevo Proyecto",JOptionPane.PLAIN_MESSAGE);
        if(!nombreProyecto.isEmpty()){
           Proyecto proyect = new Proyecto(this);
           proyect.setNombreProyecto(nombreProyecto);
           Proyectos.insertarProyecto(jTabbedPane1, proyect);
           listaProyectos.addLast(proyect);
           
           this.principal.setnProyectos(principal.getnProyectos()+1);
           
           return true;
        }else{
            JOptionPane.showMessageDialog(this,"El proyecto debe de tener un nombre","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        }catch(NullPointerException e){
            return false;
        }

    }

    public LinkedList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(LinkedList<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
