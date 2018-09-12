
package proestudent.clases;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import proestudent.Conexion;
import proestudent.ProEstudent;
import proestudent.Vistas.jPanels.tareas.ContenedorTareas;
import proestudent.Vistas.jPanels.tareas.TabTareas;
import proestudent.Vistas.jPanels.tareas.Tarea;


public class Tareas {
     public static void eliminarProfesores(){
            Conexion conexionNota = new Conexion();
        try {   
                String insertCli="DELETE t, m , p from profesor as p \n"
                               + "LEFT JOIN materia as m on p.id = m.profesor \n"
                               + "LEFT JOIN tareas as t ON m.id = t.materia \n"
                               + "WHERE p.usuario = "+ ProEstudent.USUARIO;
                Statement st = conexionNota.getConexion().createStatement();
                PreparedStatement stmt =conexionNota.getConexion().prepareStatement(insertCli);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
         
     }
     public static void eliminarMaterias(){
              Conexion conexionNota = new Conexion();
        try {   
                String insertCli="DELETE m , p from materia as m \n"
                               + "LEFT JOIN profesor as p ON m.profesor = p.id \n";
                Statement st = conexionNota.getConexion().createStatement();
                PreparedStatement stmt =conexionNota.getConexion().prepareStatement(insertCli);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
     }

     public static void guardarProfesor(TabTareas tTarea){
         Conexion conexionNota = new Conexion();
          try{
            String insertCli = "INSERT INTO Profesor (nombre, usuario) VALUES (?,?)";
            PreparedStatement pstmt = conexionNota.getConexion().prepareStatement(insertCli);
            for (Profesor profesor : TabTareas.getListaProfesores()) {
               pstmt.setString(1, profesor.getNombre());
               pstmt.setInt(2, ProEstudent.USUARIO);
               System.out.println(profesor.getId());
               pstmt.executeUpdate();
               profesor.setId(tTarea.colocarIdProfesor(profesor));
            }
            
            pstmt.close();
        }
        catch(SQLException ex){
            
     }
     }
     public static void guardarMaterias(TabTareas tTarea){
         Conexion conexionNota = new Conexion();
          try{
            String insertCli = "INSERT INTO Materia (nombre,profesor, prioridad) VALUES (?,?,?)";
            PreparedStatement pstmt = conexionNota.getConexion().prepareStatement(insertCli);
            for (Materia materia : TabTareas.getListaMateria()) {
               pstmt.setString(1,materia.getNombreMateria());
               pstmt.setInt(2, materia.getProfesor().getId());
               pstmt.setInt(3, materia.getPrioridad());
               pstmt.executeUpdate();
               materia.setId(tTarea.buscarIdMateria(materia));
            }
            pstmt.close();
        }
        catch(SQLException ex){
            
     }
     }
     public static void guardarTareas(TabTareas tTarea){
         Conexion conexionNota = new Conexion();
        try{
            String insertCli = "INSERT INTO Tareas (titulo,contenido,diaFinalizacion, materia) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conexionNota.getConexion().prepareStatement(insertCli);
            for (ContenedorTareas contenedor : tTarea.getListaContenedores()) {
                for(Tarea tarea : contenedor.getArrTareas()){
                    if (tarea != null) {
                        pstmt.setString(1, tarea.getTitulo());
                        pstmt.setString(2, tarea.getContenido());
                        pstmt.setString(3, tarea.getFecha());
                        pstmt.setInt(4, tarea.getMateria().getId());
                        pstmt.executeUpdate();
                    }
                }
            }
            pstmt.close();
        }
        catch(SQLException ex){
            
        }
     }
     public static void destruir(Tarea tarea,ContenedorTareas contenedor){
            contenedor.getArrPaneles()[tarea.getPosicion()].remove(tarea);
            contenedor.getArrPaneles()[tarea.getPosicion()].updateUI();
            contenedor.getArrTareas()[tarea.getPosicion()]=null;
            contenedor.setTareasCreadas(contenedor.getTareasCreadas()-1);
            System.out.println(""+contenedor.getTareasCreadas());
    }
     
     public static void insertarNota(JPanel panel, Tarea tarea,ContenedorTareas contenedor){
        panel.updateUI();
        tarea.setSize(321, 319);
        panel.add(tarea, BorderLayout.CENTER);
        tarea.setVisible(true);
        contenedor.getArrTareas()[tarea.getPosicion()]=tarea; 
    } 
    public static void insertarTabTarea(JPanel panel,TabTareas tTarea){
         panel.updateUI();
        
         tTarea.setSize(1106, 680);
         panel.add( tTarea, BorderLayout.CENTER);
         tTarea.setVisible(false);
    }
  
     public static void insertarContenedorTarea(JTabbedPane tPane,ContenedorTareas container){
        tPane.updateUI();
        container.setSize(1138, 680);
        tPane.add("         ",container);
        container.setVisible(true);
    }
      public static void insertarContenedorTarea(JTabbedPane tPane,ContenedorTareas container,String nombre){
        tPane.updateUI();
        container.updateUI();
        container.setSize(1138, 680);
        tPane.add(nombre,container);
        container.setVisible(true);
    }
}
