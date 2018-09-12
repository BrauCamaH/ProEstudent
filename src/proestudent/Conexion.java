
package proestudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.*;


public class Conexion {
      private Connection conexion;

    public Conexion(){
        this.MySQLConnect();
    }
    public Connection getConexion(){
       return conexion;
    }
    
    Statement comando = null;
    ResultSet registro;
    private final String dataBase = ProEstudent.DATABASE;
    
    private void MySQLConnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost:3306/" + dataBase;
            String usuario = "root";
            String pass = "87654321";
            conexion = DriverManager.getConnection(servidor, usuario, pass);
            System.out.println("Se ha hecho conexión con la base de datos: " + dataBase);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
            System.out.println(ex.getMessage());
        }
    }
 
    
}
