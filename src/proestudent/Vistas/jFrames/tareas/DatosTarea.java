
package proestudent.Vistas.jFrames.tareas;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;


import proestudent.Vistas.jPanels.tareas.Tarea;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import proestudent.Vistas.jPanels.tareas.TabTareas;
import proestudent.clases.Tareas;
public class DatosTarea extends javax.swing.JFrame {
    private Tarea tarea;
    //private final CrearMateria cMateria;
    public DatosTarea() {
        
        initComponents(); 
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        DatosTarea.actualizarMaterias(this.materia);
    }
      @Override  
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("proestudent/Imagenes/tarea.png"));
        return retValue;
    }
    public DatosTarea(Tarea tarea)  throws NullPointerException {
        initComponents();
        this.tarea = tarea;
        this.setResizable(false);
        this.setLocationRelativeTo(tarea.getComponent(tarea.getPosicion()));
        DatosTarea.actualizarMaterias(this.materia);
    }
    public static  void actualizarMaterias (JComboBox<String>  materia){
        if(!TabTareas.getListaMateria().isEmpty()){
            materia.removeAllItems();
            materia.addItem("Materia");
            for (int i = 0; i <TabTareas.getListaMateria().size(); i++) {
                materia.addItem(TabTareas.getListaMateria().get(i).getNombreMateria());
            }
        }
    }
    public  String ObtenerFecha(Tarea tarea){
       SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
       return fecha.format(fechaEntrega.getDate());
    }

    public JComboBox<String> getMateria() {
        return materia;
    }

    public void setMateria(JComboBox<String> materia) {
        this.materia = materia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechaEntrega = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        materia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        crearMateria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(fechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 140, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Seleccione día de entrega : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Seleccione Materia :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 40));

        materia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materia" }));
        materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiaActionPerformed(evt);
            }
        });
        getContentPane().add(materia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Complete los campos para crear una Tarea");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 550, -1));

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(204, 255, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 255, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 10, 170));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Si no tienes materias");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 60));

        crearMateria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        crearMateria.setForeground(new java.awt.Color(0, 0, 204));
        crearMateria.setText("crea una");
        crearMateria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearMateriaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearMateriaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                crearMateriaMousePressed(evt);
            }
        });
        getContentPane().add(crearMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 60, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void crearMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMateriaMouseClicked
        CrearMateria cMateria = new CrearMateria ();
        cMateria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_crearMateriaMouseClicked

    private void crearMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMateriaMouseExited
        crearMateria.setForeground(Color.blue);
    }//GEN-LAST:event_crearMateriaMouseExited

    private void crearMateriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMateriaMousePressed
        crearMateria.setForeground(Color.darkGray);
    }//GEN-LAST:event_crearMateriaMousePressed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
      try{ 
        if(materia.getSelectedIndex()!=0){ 
           tarea.setDatosDeMateria(TabTareas.getListaMateria().get(materia.getSelectedIndex()-1));
           tarea.setFecha(this.ObtenerFecha(tarea));
           Tareas.insertarNota(tarea.getContenedor().getArrPaneles()[tarea.getPosicion()],tarea,tarea.getContenedor());
           tarea.mostrarColorEnDiasFaltantes(tarea.obtenerDiasFaltantes(tarea.getFecha()));
           this.dispose();}
       else{
           JOptionPane.showMessageDialog(this,"No se han ingresado todos los datos","Error ",JOptionPane.WARNING_MESSAGE);
       }}catch(NullPointerException np){
           JOptionPane.showMessageDialog(this,"No se han ingresado todos los datos","Error ",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_aceptarActionPerformed

    private void materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materiaActionPerformed


    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(DatosTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatosTarea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel crearMateria;
    private com.toedter.calendar.JDateChooser fechaEntrega;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> materia;
    // End of variables declaration//GEN-END:variables
}
