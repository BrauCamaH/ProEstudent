package proestudent.Vistas.jFrames;

import proestudent.Vistas.jFrames.tareas.CrearMateria;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import proestudent.Vistas.jFrames.tareas.CrearProfesor;
import proestudent.Vistas.jFrames.tareas.MostrarMateria;
import proestudent.Vistas.jFrames.tareas.MostrarProfesores;
import proestudent.Vistas.jPanels.notas.TabNotas;
import proestudent.Vistas.jPanels.proyectos.TabProyectos;
import proestudent.Vistas.jPanels.tareas.TabTareas;
import proestudent.clases.Notas;
import proestudent.clases.Proyectos;
import proestudent.clases.Tareas;
 
public class Principal extends javax.swing.JFrame {
    private int nProyectos=0;
    private Guardando guardar;
    private final TabNotas tNota;
    private final TabTareas tTarea;
    private final TabProyectos tProyect;
    @Override  
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("proestudent/Imagenes/icono.png"));
        return retValue;
    }
    public Principal() {
        initComponents();
        this.jLabelProyecto.setVisible(false);
        this.nuevoProyecto.setVisible(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tNota= new TabNotas();
        tTarea= new TabTareas();
        tProyect= new TabProyectos(this);
        Notas.insertarTabNota(contentPanel, tNota);
        Tareas.insertarTabTarea(contentPanel, tTarea);
        Proyectos.insertarTabProyectos(contentPanel, tProyect);
        
        this.verificarProyectos();
    }

    public final void verificarProyectos(){
        if(nProyectos==0){
            this.jLabelProyecto.setVisible(true);
            this.nuevoProyecto.setVisible(true);
         proyectos.setForeground(java.awt.Color.white);
        }
    }
    public int getnProyectos() {
        return nProyectos;
    }

    public void setnProyectos(int nProyectos) {
        this.nProyectos = nProyectos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notas = new javax.swing.JLabel();
        proyectos = new javax.swing.JLabel();
        tareas = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        nuevoProyecto = new javax.swing.JButton();
        jLabelProyecto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        opcionesUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        archivo = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        notas.setForeground(new java.awt.Color(51, 51, 51));
        notas.setText("Notas");
        notas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notas.setFocusCycleRoot(true);
        notas.setFocusTraversalPolicyProvider(true);
        notas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notasMouseClicked(evt);
            }
        });
        getContentPane().add(notas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 40));

        proyectos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        proyectos.setForeground(new java.awt.Color(51, 51, 51));
        proyectos.setText("Proyectos");
        proyectos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        proyectos.setFocusCycleRoot(true);
        proyectos.setFocusTraversalPolicyProvider(true);
        proyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proyectosMouseClicked(evt);
            }
        });
        getContentPane().add(proyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 140, 40));

        tareas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tareas.setForeground(new java.awt.Color(51, 51, 51));
        tareas.setText("Tareas");
        tareas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tareas.setFocusCycleRoot(true);
        tareas.setFocusTraversalPolicyProvider(true);
        tareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tareasMouseClicked(evt);
            }
        });
        getContentPane().add(tareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 140, 40));

        nuevoProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/proyecto.png"))); // NOI18N
        nuevoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProyectoActionPerformed(evt);
            }
        });

        jLabelProyecto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelProyecto.setForeground(new java.awt.Color(51, 51, 51));
        jLabelProyecto.setText("Click en boton para crear un proyecto");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addComponent(nuevoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(492, 492, 492))
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabelProyecto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(jLabelProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nuevoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );

        nuevoProyecto.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1130, 680));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 20, 690));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 170, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 170, 10));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 170, 10));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 170, 10));

        opcionesUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuenta", "Info Usuario", "Cerrar Sesión" }));
        opcionesUsuario.setLightWeightPopupEnabled(false);
        opcionesUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(opcionesUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/user.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 160));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        archivo.add(jMenu1);

        jMenu2.setText("Tareas");

        jMenuItem6.setText("Crear Profesor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem3.setText("Crear Materia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Ver / Moficar Materia");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Ver / Moficar Profesor");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        archivo.add(jMenu2);

        setJMenuBar(archivo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void notasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notasMouseClicked
        notas.setForeground(java.awt.Color.white);
        proyectos.setForeground(java.awt.Color.darkGray);
        tareas.setForeground(java.awt.Color.darkGray);
        tNota.setVisible(true);
        tTarea.setVisible(false);
        tProyect.setVisible(false);
        
         
        this.jLabelProyecto.setVisible(false);
        this.nuevoProyecto.setVisible(false);
    }//GEN-LAST:event_notasMouseClicked

    private void proyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proyectosMouseClicked
        proyectos.setForeground(java.awt.Color.white);
        tareas.setForeground(java.awt.Color.darkGray);
        notas.setForeground(java.awt.Color.darkGray);
        tNota.setVisible(false);
        tTarea.setVisible(false);
        tProyect.setVisible(true);
        
        this.verificarProyectos();
        
    }//GEN-LAST:event_proyectosMouseClicked

    private void tareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tareasMouseClicked
        tareas.setForeground(java.awt.Color.white);
        proyectos.setForeground(java.awt.Color.darkGray);
        notas.setForeground(java.awt.Color.darkGray);
        tNota.setVisible(false);
        tTarea.setVisible(true);
        tProyect.setVisible(false);
        
        this.jLabelProyecto.setVisible(false);
        this.nuevoProyecto.setVisible(false);
    }//GEN-LAST:event_tareasMouseClicked
 
    private void opcionesUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesUsuarioActionPerformed
        switch(opcionesUsuario.getSelectedIndex()){
            case 1:
                    new InfoUsuario().setVisible(true);
                    opcionesUsuario.setSelectedIndex(0);   
            break;
            case 2:
                 int opcion=JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar sesión", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                 if(opcion==0){    
                    InicioSesion inicio = new InicioSesion();
                    this.dispose();
                    inicio.setVisible(true);
                    opcionesUsuario.setSelectedIndex(0);
                 }
            break;
            default :
                opcionesUsuario.setSelectedIndex(0);
            break;
        }
    }//GEN-LAST:event_opcionesUsuarioActionPerformed

    private void nuevoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProyectoActionPerformed
        if(tProyect.crearNuevoProyecto()){
            this.jLabelProyecto.setVisible(false);
            this.nuevoProyecto.setVisible(false);
            Proyectos.insertarTabProyectos(contentPanel, tProyect);
            tProyect.setVisible(true);}
    }//GEN-LAST:event_nuevoProyectoActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       int opcion=JOptionPane.showConfirmDialog(this, "¿Desea salir del programa?", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       if (opcion==0){
            System.exit(0);
       }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        guardar= new Guardando();
        guardar.setVisible(true);
        guardar.comenzar();
        
        Tareas.eliminarProfesores();
        Tareas.guardarProfesor(tTarea);
        Tareas.guardarMaterias(tTarea);
        Tareas.guardarTareas(tTarea);

        Proyectos.eliminarProyectos();
        Proyectos.guardarProyectos(tProyect);
        
        Proyectos.guardarTareasProyecto(tProyect);

        Notas.eliminarBaseDeDatos();
        Notas.guardarNotas(tNota);
        guardar.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CrearMateria ct = new CrearMateria();
        ct.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int opcion=JOptionPane.showConfirmDialog(this, "¿Desea salir del programa?", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       if (opcion==0){
           System.exit(0);
       }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new MostrarMateria (tTarea).setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new MostrarProfesores(tTarea).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new CrearProfesor().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar archivo;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelProyecto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel notas;
    private javax.swing.JButton nuevoProyecto;
    private javax.swing.JComboBox<String> opcionesUsuario;
    private javax.swing.JLabel proyectos;
    private javax.swing.JLabel tareas;
    // End of variables declaration//GEN-END:variables
}
