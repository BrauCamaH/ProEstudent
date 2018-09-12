package proestudent.Vistas.jFrames.tareas;

import java.awt.Color;
import proestudent.Vistas.jFrames.tareas.DatosTarea;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import proestudent.Vistas.jPanels.tareas.TabTareas;
import proestudent.clases.Materia;
import proestudent.clases.Profesor;

public class CrearMateria extends javax.swing.JFrame {
    
    public CrearMateria(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.actualizarProfesores();
    }
    
      @Override  
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("proestudent/Imagenes/materia.png"));
        return retValue;
    }
    private void actualizarProfesores(){
        comboProfesores.removeAllItems();
        comboProfesores.addItem("Profesor");
        for(Profesor profesor: TabTareas.getListaProfesores()){
            comboProfesores.addItem(profesor.getNombre());
        }
    }
    private void vaciarMateria(){
        nombreMateria.setText("");
        this.comboProfesores.setSelectedIndex(0);
        this.prioridad.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombreMateria = new javax.swing.JTextField();
        comboProfesores = new javax.swing.JComboBox<>();
        aceptar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        prioridad = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        crearMateria = new javax.swing.JLabel();

        jSeparator1.setBackground(new java.awt.Color(204, 255, 204));
        jSeparator1.setForeground(new java.awt.Color(204, 255, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        setAlwaysOnTop(true);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Complete los campos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Seleccione Profesor: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 80));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Ingrese Nombre Materia:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 50));

        nombreMateria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreMateriaActionPerformed(evt);
            }
        });
        getContentPane().add(nombreMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 268, 30));

        comboProfesores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profesor" }));
        comboProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProfesoresActionPerformed(evt);
            }
        });
        getContentPane().add(comboProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));

        aceptar.setText("Crear la materia");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setText("Crear Materia");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 50));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Seleccióne Prioridad:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 80));

        prioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridad", "alta", "media", "baja" }));
        prioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prioridadActionPerformed(evt);
            }
        });
        getContentPane().add(prioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Si no tienes profesores");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 60));

        crearMateria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        crearMateria.setForeground(new java.awt.Color(0, 0, 204));
        crearMateria.setText("crear uno");
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
        getContentPane().add(crearMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 60, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreMateriaActionPerformed
   
    }//GEN-LAST:event_nombreMateriaActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        String nMateria=nombreMateria.getText();
        int prio=prioridad.getSelectedIndex();
        int profesor = comboProfesores.getSelectedIndex();
        if(!nMateria.isEmpty()&&  profesor!=0&&prio!=0){
            Materia materia= new Materia (TabTareas.getListaProfesores().get(profesor-1),nMateria,prio);
            TabTareas.getListaMateria().addLast(materia);
            JOptionPane.showMessageDialog(this,"Se ha agregado una materia","Materia",JOptionPane.INFORMATION_MESSAGE);
            
            this.vaciarMateria();
        }else{
             JOptionPane.showMessageDialog(this,"No se han ingresado todos los datos","Error ",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void prioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prioridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prioridadActionPerformed

    private void comboProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProfesoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProfesoresActionPerformed

    private void crearMateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMateriaMouseClicked
        new CrearProfesor().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_crearMateriaMouseClicked

    private void crearMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMateriaMouseExited
        crearMateria.setForeground(Color.blue);
    }//GEN-LAST:event_crearMateriaMouseExited

    private void crearMateriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMateriaMousePressed
        crearMateria.setForeground(Color.darkGray);
    }//GEN-LAST:event_crearMateriaMousePressed
    
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
                new CrearMateria().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JComboBox<String> comboProfesores;
    private javax.swing.JLabel crearMateria;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nombreMateria;
    private javax.swing.JComboBox<String> prioridad;
    // End of variables declaration//GEN-END:variables
}
