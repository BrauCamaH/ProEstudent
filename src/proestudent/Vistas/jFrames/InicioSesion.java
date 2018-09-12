
package proestudent.Vistas.jFrames;


import java.awt.Color;
import java.util.Arrays;
import javax.swing.JOptionPane;
import proestudent.ProEstudent;
import java.awt.Image;
import java.awt.Toolkit;
public class InicioSesion extends javax.swing.JFrame {
   
    private CrearUsuario cUsuario;
    private Principal ventanaP;
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("proestudent/Imagenes/icono.png"));
        return retValue;
    }
    public InicioSesion() {
        initComponents();
        
        this.setSize(824, 513);
        this.setLocationRelativeTo(null);
        crearCuenta.setForeground(Color.blue);
        jCBRecodarSesion.setVisible(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        imagenUsuario = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        correoElectronico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        iniciarSesion = new javax.swing.JButton();
        crearCuenta = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCBRecodarSesion = new javax.swing.JCheckBox();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(204, 255, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 255, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 10, 383));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 55, -1, 34));

        imagenUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/logIn.png"))); // NOI18N
        getContentPane().add(imagenUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 276, 286));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 242, 43));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 25));

        correoElectronico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(correoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 268, 42));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Correo Electrónico");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Ingrese Datos Para Iniciar Sesión");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 630, 40));

        iniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iniciarSesion.setText("Iniciar Sesión");
        iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 170, 50));

        crearCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        crearCuenta.setForeground(new java.awt.Color(0, 0, 204));
        crearCuenta.setText("crea una");
        crearCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearCuentaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearCuentaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                crearCuentaMousePressed(evt);
            }
        });
        getContentPane().add(crearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 60, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText(".");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText(" .");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Si no tienes una cuenta ProEstudent  ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jCBRecodarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCBRecodarSesion.setForeground(new java.awt.Color(102, 102, 255));
        jCBRecodarSesion.setText("Recordar inicio de sesión");
        getContentPane().add(jCBRecodarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearCuentaMouseClicked
        cUsuario = new CrearUsuario();
        cUsuario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_crearCuentaMouseClicked

    private void crearCuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearCuentaMousePressed
        crearCuenta.setForeground(Color.darkGray);
    }//GEN-LAST:event_crearCuentaMousePressed

    private void crearCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearCuentaMouseExited
         crearCuenta.setForeground(Color.blue);
    }//GEN-LAST:event_crearCuentaMouseExited

    private void iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionActionPerformed
        if( ProEstudent.iniciarSesion(correoElectronico, password)){
            //JOptionPane.showMessageDialog(null, "Se ha Ingresado al sistema ","",JOptionPane.PLAIN_MESSAGE);
            System.out.println("Se ha ingresado al sistema");
            ventanaP =new Principal();
            ventanaP.setVisible(true);
            this.setVisible(false);
        }else if((correoElectronico.getText().isEmpty()&& Arrays.toString(password.getPassword()).isEmpty())==false){
            JOptionPane.showMessageDialog(null, "No existe el usuario ","",JOptionPane.WARNING_MESSAGE);
        }      
    }//GEN-LAST:event_iniciarSesionActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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

    
        java.awt.EventQueue.invokeLater(() -> {
            new InicioSesion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correoElectronico;
    private javax.swing.JLabel crearCuenta;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JButton iniciarSesion;
    private javax.swing.JCheckBox jCBRecodarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
