
package proestudent.clases;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import proestudent.Conexion;
import proestudent.ProEstudent;
import proestudent.Vistas.jPanels.proyectos.Proyecto;
import proestudent.Vistas.jPanels.proyectos.TabProyectos;

    public class Proyectos {
       
         public static void eliminarProyectos(){
        Conexion conexionNota = new Conexion();
        try {   
                String insertCli="DELETE p , tp from proyecto as p LEFT JOIN tareaProyecto tp on p.id = tp.proyecto where p.usuario="+ProEstudent.USUARIO;
                PreparedStatement stmt =conexionNota.getConexion().prepareStatement(insertCli);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public static void eliminarTareas(TabProyectos tProyecto){
            Conexion conexionNota = new Conexion();
        try { 
            PreparedStatement stmt ;
             for(Proyecto proyecto : tProyecto.getListaProyectos()){
                String insertCli="DELETE  FROM TareaProyecto WHERE proyecto="+proyecto.getId();
                stmt =conexionNota.getConexion().prepareStatement(insertCli);
                stmt.executeUpdate();
                stmt.close();
             }
             
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     public static void guardarTareasProyecto(TabProyectos tProyecto){
         Conexion conexion= new Conexion();
         try {   
                String insertCli="INSERT INTO TareaProyecto (tarea, descripcion, columna, proyecto) VALUES (?,?,?,?)";
                PreparedStatement stmt =conexion.getConexion().prepareStatement(insertCli);

                for(Proyecto proyecto : tProyecto.getListaProyectos()){
                  
                    for(TareaProyecto  tarea: proyecto.getListaTareasProyecto())  {            
                        stmt.setString(1, tarea.getTarea());
                        stmt.setString(2, tarea.getDescripción());
                        stmt.setInt(3, tarea.getColumna());
                        stmt.setInt(4,proyecto.getId());
                        stmt.executeUpdate();
                    }
                    
                }

                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
     
     public static void guardarProyectos(TabProyectos tProyecto){
         Conexion conexion = new Conexion();
          try {   
                String insertCli="INSERT INTO Proyecto(nombre,usuario) VALUES (?,?)";
                PreparedStatement stmt =conexion.getConexion().prepareStatement(insertCli);
               
                for(Proyecto proyecto : tProyecto.getListaProyectos()){
                    stmt.setString(1, proyecto.getNombreProyecto());
                    stmt.setInt(2, ProEstudent.USUARIO);
                     stmt.executeUpdate();
                     proyecto.setId(tProyecto.buscarIdProyecto(proyecto));
                }
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
          
     }
     
    
     public static void insertarTabProyectos(JPanel panel,TabProyectos tProyect){
         panel.updateUI();
        
         tProyect.setSize(1106, 680);
         panel.add(tProyect, BorderLayout.CENTER);
         tProyect.setVisible(false);
    }
     
     public static void insertarProyecto(JTabbedPane tPane, Proyecto proyect){
         tPane.updateUI();
         proyect.setSize(1050, 680);
         tPane.add("              ", proyect);
         tPane.setVisible(true);
     }
  
}
