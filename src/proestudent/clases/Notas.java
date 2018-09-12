
package proestudent.clases;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import proestudent.Conexion;
import proestudent.ProEstudent;
import proestudent.Vistas.jPanels.notas.ContenedorNotas;
import proestudent.Vistas.jPanels.tareas.ContenedorTareas;
import proestudent.Vistas.jPanels.notas.Nota;
import proestudent.Vistas.jPanels.notas.TabNotas;

//Clase Notas con métodos Estaticos
public class Notas {
  
    public static void eliminarBaseDeDatos(){
        Conexion conexionNota = new Conexion();
        try {   
                String insertCli="DELETE FROM notas WHERE usuario="+ProEstudent.USUARIO;
                Statement st = conexionNota.getConexion().createStatement();
                PreparedStatement stmt =conexionNota.getConexion().prepareStatement(insertCli);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void guardarNotas(TabNotas tNotas){
        Conexion conexionNota = new Conexion();
        try {
              String insertCli = "INSERT INTO notas(titulo,contenido,usuario) VALUES (?,?,?)";
              PreparedStatement pstmt = conexionNota.getConexion().prepareStatement(insertCli);
            for (int i = 0; i <tNotas.getListaContenedores().size(); i++) {
                for (Nota arrNota : tNotas.getListaContenedores(i).getArrNotas()) {
                    if (arrNota != null) {
                        pstmt.setString(1, arrNota.getTituloNota());
                        pstmt.setString(2, arrNota.getContenidoNota());
                        pstmt.setInt(3,ProEstudent.USUARIO);
                        pstmt.executeUpdate();
                        // SELECT contenido FROM notas WHERE categoria = 3
                   } 
                    else {
                        pstmt.setString(1,"");
                        pstmt.setString(2,"");
                        pstmt.setInt(3,ProEstudent.USUARIO);
                        pstmt.executeUpdate();
                   }
                }
            }
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProEstudent.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public static void destruir(Nota nota,ContenedorNotas contenedor){
       int opcion=JOptionPane.showConfirmDialog(nota, "¿Desea eliminar la nota?", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       if(opcion==0){ 
        contenedor.getArrPaneles()[nota.getPosicion()].remove( nota);
        contenedor.getArrPaneles()[nota.getPosicion()].updateUI();
        contenedor.getArrNotas()[nota.getPosicion()]=null;
        contenedor.setNotasCreadas(contenedor.getNotasCreadas()-1);
       }
       
    }
    
    public static void insertarNota(JPanel panel, Nota nota,ContenedorNotas contenedor){
        panel.updateUI();
        nota.setSize(321, 319);
        panel.add(nota, BorderLayout.CENTER);
        nota.setVisible(true);
        contenedor.getArrNotas()[nota.getPosicion()]=nota; 
    }
    
    public static void insertarContenedorNota(JPanel panel,ContenedorNotas container ){
        panel.updateUI();
        container.setSize(1165, 680);
        panel.add(container, BorderLayout.CENTER);
        container.setVisible(true);
    }
    
    public static void insertarContenedorNota(JTabbedPane tPane,ContenedorNotas container,String nombre){
        tPane.updateUI();
        container.updateUI();
        container.setSize(1165, 680);
        tPane.addTab(nombre,container);
        container.setVisible(true);
    }
    
    public static void insertarContenedorNota(JTabbedPane tPane,ContenedorTareas container){
        container.setSize(1165, 680);
        tPane.addTab("      ",container);
        container.setVisible(true);
        container.updateUI();
        tPane.updateUI();
    }
    
    public static void insertarTabNota(JPanel panel,TabNotas tNota){
        panel.updateUI();
        tNota.setSize(1064, 680);
        panel.add(tNota, BorderLayout.CENTER);
        tNota.setVisible(false);
    }
  
    
}


