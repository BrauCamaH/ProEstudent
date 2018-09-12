
package proestudent.Vistas.jFrames.tareas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proestudent.Vistas.jPanels.tareas.TabTareas;
import proestudent.clases.Materia;
import proestudent.clases.Profesor;

/**
 *
 * @author ACER
 */
public class MostrarProfesores extends javax.swing.JFrame {
      private TabTareas tTareas;
      
    /**
     * Creates new form MostrarProfesores
     * @param tTareas
     */
    public MostrarProfesores(TabTareas tTareas) {
        initComponents();
        this.tTareas= tTareas;
        this.setLocationRelativeTo(null);
        this.mostrarProfesores();
    }
      @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("proestudent/Imagenes/tarea.png"));
        return retValue;
    }
    private void mostrarProfesores(){
        DefaultTableModel modelo=(DefaultTableModel) jTable.getModel(); 
             Object [] fila=new Object[2]; 
             fila [1]= "Click Para Actualizar";
        for (Profesor profesor : TabTareas.getListaProfesores()) {
             
             fila[0]=profesor.getNombre();
            
             modelo.addRow(fila); 
             jTable.setModel(modelo);
        }
    }
     public void guardarCambios(){
       int x=0;
       jTable.selectAll();
       jTable.clearSelection();
       
       
       DefaultTableModel modelo=(DefaultTableModel) jTable.getModel(); 
       jTable.setModel(modelo);
       
       String texto;
       String prioTxt;
       for(Profesor profesor : TabTareas.getListaProfesores()){
           texto = modelo.getValueAt(x, 0).toString();
           profesor.setNombre(texto);
            x++;
       }
       JOptionPane.showMessageDialog(null,"Se han guardado los cambios","Mensaje",JOptionPane.PLAIN_MESSAGE);
       jEliminar.setEnabled(false);
    }
     public void eliminarProfesorEnTabla(JTable tabla){
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel(); 
        int fila = tabla.getSelectedRow()+1;
        TabTareas.getListaProfesores().remove(fila);
        modelo.removeRow(fila);
    }

    public TabTareas gettTareas() {
        return tTareas;
    }

    public void settTareas(TabTareas tTareas) {
        this.tTareas = tTareas;
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jEliminar = new javax.swing.JButton();

        jButton3.setText("Guardar Cambios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Profesores");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setColumnSelectionAllowed(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTableMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jEliminar.setText("Eliminar");
        jEliminar.setEnabled(false);
        jEliminar.setFocusCycleRoot(true);
        jEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel4)
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jEliminar))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(jEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardarCambios();
        tTareas.actualizarTareas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActionPerformed
        int opcion=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el  "
                                                     + "\n todas la materias y tareas "
                                                     + "\n que se relacine con el profesor se eliminaran", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
         if(opcion==0){ 
             tTareas.recolectarMaterias(TabTareas.getListaProfesores().get(jTable.getSelectedRow()+1));
             this.eliminarProfesorEnTabla(jTable);
             jEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_jEliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseExited
        jTable.clearSelection();
    }//GEN-LAST:event_jTableMouseExited

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
       jEliminar.setEnabled(true);
    }//GEN-LAST:event_jTableMouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jEliminar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
