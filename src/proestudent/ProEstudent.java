
package proestudent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.JTextField;
import proestudent.Vistas.jFrames.InicioSesion;
import proestudent.Vistas.jFrames.Principal;

//Braulio Guadalupe Camarena Huerta
public class ProEstudent {
    public  static final String DATABASE ="PROESTUDENT"; 
    public static  int USUARIO=1;
    public static  Principal SESION;
    
    public static boolean iniciarSesion( JTextField correo, JPasswordField password){
        Conexion conection1 = new Conexion();
        boolean bandera=false;
        char[] arrayC = password.getPassword();

        String datosCorreo=correo.getText();
        String datosPassword=new String(arrayC);
        if(datosPassword.isEmpty()||datosCorreo.isEmpty()){
            JOptionPane.showMessageDialog(null,"No se han llenado todos los campos","",JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                Statement st = conection1.getConexion().createStatement();
                ResultSet set =st.executeQuery("select id, email, contraseña from usuario");
                while(set.next()){
                    if(datosCorreo.equals(set.getString("email")) && datosPassword.equals(set.getString("contraseña"))){
                        System.out.println("Usuario encontrado");
                        ProEstudent.USUARIO=set.getInt(1);
                        System.out.println(""+ProEstudent.USUARIO);
                        bandera=true;
                    }
                }
                set.close();
                st.close();

            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return bandera;
    }
    public static boolean crearUsuario(JTextField datosNombre, JTextField datosApellido,JTextField datosCorreo, JPasswordField datosPassword){
        Conexion conection1 = new Conexion();
        boolean bandera=false;
        char[] arrayC = datosPassword.getPassword();
        String nombre=datosNombre.getText();
        String apellido= datosApellido.getText();
        String correo=datosCorreo.getText();
        String password= new String(arrayC);
        try {
            Statement st = conection1.getConexion().createStatement();
            String insertCli = "INSERT INTO usuario ( nombre, apellido, email, contraseña) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conection1.getConexion().prepareStatement(insertCli);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.setString(4, password);
            
            pstmt.executeUpdate();
            
            bandera=true;
            pstmt.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProEstudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bandera;
    }
    
    public ProEstudent(){
         Inicio inicio = new Inicio();
         inicio.setVisible(true);
         if (inicio.comenzar()) {
            
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            SESION = new Principal();
            SESION.setVisible(true);
        });
         }
    }
    public static void main(String[] args) {
        ProEstudent proyecto = new ProEstudent();
   
    }
    
}
