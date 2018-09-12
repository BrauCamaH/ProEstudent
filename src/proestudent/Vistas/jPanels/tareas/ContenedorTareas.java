package proestudent.Vistas.jPanels.tareas;

import proestudent.Vistas.jPanels.tareas.Tarea;
import proestudent.Vistas.jPanels.tareas.TabTareas;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proestudent.Vistas.jFrames.tareas.DatosTarea;


public class ContenedorTareas extends javax.swing.JPanel {
    private DatosTarea dt ;
    private TabTareas tTareas;
    private JPanel arrPaneles[];
    private Tarea arrTareas[];
    private int tareasCreadas;
    public ContenedorTareas(TabTareas tpane) {
        initComponents();
        eliminarContenedor.setVisible(false);
        tTareas=tpane;
        arrPaneles=new JPanel[6];
        arrTareas= new Tarea[6];
        paneles();
        tareas();
    }
        private void  tareas(){
        for (int i = 0; i <arrTareas.length; i++) {
            arrTareas[i]=null;
        }
    }
     public void setVisibleEliminarContenedor(boolean enbled){
        eliminarContenedor.setVisible(enbled);
    }
     
     public int buscarEspacioVacio( ContenedorTareas contenedor){
         int espacioVacio=0;
         for (int i = 0; i <6; i++) {
             if(contenedor.getArrTareas()[i]==null){
                 espacioVacio= i;
                 break;
             } 
         }
          return espacioVacio;
         
      } 

    public JPanel[] getArrPaneles() {
        return arrPaneles;
    }

    public void setArrPaneles(JPanel[] arrPaneles) {
        this.arrPaneles = arrPaneles;
    }

    public Tarea[] getArrTareas() {
        return arrTareas;
    }

    public void setArrTareas(Tarea[] arrTareas) {
        this.arrTareas = arrTareas;
    }

    public int getTareasCreadas() {
        return tareasCreadas;
    }

    public void setTareasCreadas(int tareasCreadas) {
        this.tareasCreadas = tareasCreadas;
    }
    
     
    public final void paneles(){
        arrPaneles[0]=panel1;
        arrPaneles[1]=panel2;
        arrPaneles[2]=panel3;
        arrPaneles[3]=panel4;
        arrPaneles[4]=panel5;
        arrPaneles[5]=panel6;
         
    }

    public DatosTarea getDt() {
        return dt;
    }

    public void setDt(DatosTarea dt) {
        this.dt = dt;
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

        crearContenedor = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        panel6 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        insertarTareas = new javax.swing.JLabel();
        eliminarContenedor = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crearContenedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/mostrar.png"))); // NOI18N
        crearContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearContenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearContenedorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearContenedorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                crearContenedorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                crearContenedorMouseReleased(evt);
            }
        });
        add(crearContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 300, 68, 70));

        panel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        panel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        panel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        panel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, -1, -1));

        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        insertarTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/alta.png"))); // NOI18N
        insertarTareas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        insertarTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertarTareasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insertarTareasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                insertarTareasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                insertarTareasMouseReleased(evt);
            }
        });
        add(insertarTareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 220, 68, 70));

        eliminarContenedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/eliminar.png"))); // NOI18N
        eliminarContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarContenedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarContenedorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarContenedorMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarContenedorMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eliminarContenedorMouseReleased(evt);
            }
        });
        add(eliminarContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, -1, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void insertarTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarTareasMouseClicked
        if(tareasCreadas<6){  
          Tarea tarea = new Tarea(panel1, this);
          dt = new DatosTarea(tarea);
          dt.setVisible(true);
    
        }else{
           JOptionPane.showMessageDialog(null,"No se pueden insertar más de 6 Tareas","",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_insertarTareasMouseClicked
    
    private void insertarTareasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarTareasMousePressed
        insertarTareas.setEnabled(false);
    }//GEN-LAST:event_insertarTareasMousePressed

    private void insertarTareasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarTareasMouseExited
        insertarTareas.setEnabled(true);
    }//GEN-LAST:event_insertarTareasMouseExited

    private void insertarTareasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarTareasMouseReleased
        insertarTareas.setEnabled(true);
    }//GEN-LAST:event_insertarTareasMouseReleased

    private void eliminarContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarContenedorMouseClicked
         int opcion=JOptionPane.showConfirmDialog(this, "¿Desea eliminar la pestaña?", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       if (opcion==0){
            tTareas.eliminarContenedor(this);
       }
    }//GEN-LAST:event_eliminarContenedorMouseClicked

    private void eliminarContenedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarContenedorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarContenedorMouseExited

    private void eliminarContenedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarContenedorMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarContenedorMousePressed

    private void eliminarContenedorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarContenedorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarContenedorMouseReleased

    private void crearContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearContenedorMouseClicked
         tTareas.crearContenedor();
    }//GEN-LAST:event_crearContenedorMouseClicked

    private void crearContenedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearContenedorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_crearContenedorMouseExited

    private void crearContenedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearContenedorMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearContenedorMousePressed

    private void crearContenedorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearContenedorMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_crearContenedorMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel crearContenedor;
    private javax.swing.JLabel eliminarContenedor;
    private javax.swing.JLabel insertarTareas;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    // End of variables declaration//GEN-END:variables
}
