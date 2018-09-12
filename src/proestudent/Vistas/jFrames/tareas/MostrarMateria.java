
package proestudent.Vistas.jFrames.tareas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proestudent.Vistas.jPanels.tareas.TabTareas;
import proestudent.clases.Materia;

/**
 *
 * @author ACER
 */
public class MostrarMateria extends javax.swing.JFrame {
    private TabTareas tTareas;
    /**
     * Creates new form MostrarMateria
     * @param tTareas
     */
      public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("proestudent/Imagenes/tarea.png"));
        return retValue;
    }
    public MostrarMateria( TabTareas tTareas) {
        initComponents();
        this.tTareas= tTareas;
        this.mostrarMaterias();
        this.setLocationRelativeTo(null);
    }
    public String mostrarPrioridad(int columna){
        String prioridad="";
        switch(columna){
            case 1:
              prioridad = "alta";
            break;
            case 2:
              prioridad = "media";
            break;
            case 3:
              prioridad = "baja";
            break;
                
            
        }
        return prioridad;
    }
    public int obtenerValorPrioridad(String prioridad){
        int n=-1;
        switch(prioridad){
            case "alta":
                n=1;
            break;
            case "media":
                n=2;
            break;
            case "baja":
                n=3;
            break;
            default:
              JOptionPane.showMessageDialog(null,"La prioridad solo puede ser \n alta \n media \n baja","Error",JOptionPane.ERROR_MESSAGE);
            break;
        }
        
        return n;
    }
    private void mostrarMaterias(){
        for (Materia materia : TabTareas.getListaMateria()) {
                DefaultTableModel modelo=(DefaultTableModel) jTable.getModel(); 
                Object [] fila=new Object[3]; 
                fila[0]=materia.getNombreMateria();
                fila[1]=this.mostrarPrioridad(materia.getPrioridad());
                fila[2]="Click para actualizar";
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
       for(Materia materia : TabTareas.getListaMateria()){
           texto = modelo.getValueAt(x, 0).toString();
           prioTxt = modelo.getValueAt(x, 1).toString();
           materia.setNombreMateria( texto);
           int valorPrioridad = this.obtenerValorPrioridad(prioTxt);
           if(valorPrioridad >0){
               materia.setPrioridad(valorPrioridad);
           }else{
               modelo.setValueAt(this.mostrarPrioridad(materia.getPrioridad()), x, 1);
           }
           x++;
       }
       JOptionPane.showMessageDialog(null,"Se han guardado los cambios","Mensaje",JOptionPane.PLAIN_MESSAGE);
    }
    
    public void eliminarMateriaEnTabla(JTable tabla){
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel(); 
        int fila = tabla.getSelectedRow();
        TabTareas.getListaMateria().remove(fila);
        modelo.removeRow(fila);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jGuardar = new javax.swing.JButton();
        jEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Prioridad", ""
            }
        ));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jGuardar.setText("Guardar Cambios");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });

        jEliminar.setText("Eliminar");
        jEliminar.setEnabled(false);
        jEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Materias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jGuardar)
                                .addGap(46, 46, 46)
                                .addComponent(jEliminar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel4)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGuardar)
                    .addComponent(jEliminar))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        this.guardarCambios();
        tTareas.actualizarTareas();
        jEliminar.setEnabled(false);
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActionPerformed
        int opcion=JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar la materia \n todas la tareas con la materia se eliminaran", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
         if(opcion==0){ 
             tTareas.recolectarTareas(TabTareas.getListaMateria().get(jTable.getSelectedRow()));
             this.eliminarMateriaEnTabla(jTable);
             jEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_jEliminarActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
            jEliminar.setEnabled(true);
    }//GEN-LAST:event_jTableMouseClicked

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jEliminar;
    private javax.swing.JButton jGuardar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
