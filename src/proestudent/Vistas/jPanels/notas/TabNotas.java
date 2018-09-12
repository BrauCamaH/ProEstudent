
package proestudent.Vistas.jPanels.notas;

import proestudent.Vistas.jPanels.notas.Nota;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proestudent.Conexion;
import proestudent.ProEstudent;
import proestudent.clases.Notas;

public class TabNotas extends javax.swing.JPanel {
    private ContenedorNotas container;
    private LinkedList <ContenedorNotas>listaContenedores;
    public TabNotas() {
        initComponents();
        listaContenedores= new <ContenedorNotas> LinkedList();
        container = new ContenedorNotas(this);
        Notas.insertarContenedorNota(jTabbedPane, container,"        ");
        listaContenedores.addLast(container);
        
        this.cargarNotas();
    }
    private void cargarNotas(){
          Conexion conexionNota = new Conexion();
          int contenedor=0;
          int n=0;
        try {
                    String titulo;
                    String contenido;
                    Statement st = conexionNota.getConexion().createStatement();
                    ResultSet set =st.executeQuery("SELECT titulo,contenido FROM notas WHERE usuario ="+ProEstudent.USUARIO);
                        while(set.next()){
                            if (n==6){
                                this.crearContenedor();
                                contenedor++;
                                n=0;
                            }
                            titulo=set.getString("titulo");
                            contenido = set.getString("contenido");
                            if(!titulo.equals("")||!contenido.equals("")){
                                Nota nota= new Nota(this.getListaContenedores(contenedor).getArrPaneles()[n],this.getListaContenedores(contenedor),titulo, contenido);
                                Notas.insertarNota(this.getListaContenedores(contenedor).getArrPaneles()[n], nota, this.getListaContenedores(contenedor));
                            }
                            n++;
                        }
          set.close();
          st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProEstudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearContenedor(){
        ContenedorNotas contenedorNotas= new ContenedorNotas(this);
        jTabbedPane.add(contenedorNotas);
        Notas.insertarContenedorNota(jTabbedPane, contenedorNotas, "");
        contenedorNotas.setVisibleEliminarContenedor(true);
        listaContenedores.addLast(contenedorNotas);
    }

    public void eliminarContenedor(ContenedorNotas contenedor){
       int opcion=JOptionPane.showConfirmDialog(null, "¿Desea eliminar esta pestaña?", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       if(opcion==0){
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
    }
    public <ContenedorNotas>LinkedList getListaContenedores() {
        return listaContenedores;
    }
    public ContenedorNotas getListaContenedores(int i) {
        return listaContenedores.get(i);
    }
    public void setListaContenedores(LinkedList <ContenedorNotas> listaContenedores) {
        this.listaContenedores = listaContenedores;
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
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}

