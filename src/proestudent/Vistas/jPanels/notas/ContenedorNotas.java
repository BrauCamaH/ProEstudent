package proestudent.Vistas.jPanels.notas;

import proestudent.Vistas.jPanels.notas.TabNotas;
import proestudent.Vistas.jPanels.notas.Nota;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proestudent.clases.Notas;

public class ContenedorNotas extends javax.swing.JPanel {
    private final TabNotas tNotas;
    private JPanel arrPaneles[];
    private Nota arrNotas[];
    private int notasCreadas;
    private int numeroContenedor;

    public ContenedorNotas(TabNotas tpane) {
        initComponents();
        eliminarContenedor.setVisible(false);
        tNotas=tpane;
        arrPaneles=new JPanel[6];
        arrNotas= new Nota[6];
        paneles();
        notas();
    }
    private void  notas(){
        for (int i = 0; i <arrNotas.length; i++) {
            arrNotas[i]=null;
        }
    }
    
     public int buscarEspacioVacio( ContenedorNotas contenedor){
         int espacioVacio=0;
         for (int i = 0; i <6; i++) {
             if(contenedor.getArrNotas()[i]==null){
                 espacioVacio= i;
                 break;
             } 
         }
          return espacioVacio;
      } 
    public final void paneles(){
        arrPaneles[0]=panel1;
        arrPaneles[1]=panel2;
        arrPaneles[2]=panel3;
        arrPaneles[3]=panel4;
        arrPaneles[4]=panel5;
        arrPaneles[5]=panel6;
         
    }
     public void setVisibleEliminarContenedor(boolean enbled){
        eliminarContenedor.setVisible(enbled);
    }

    public JPanel[] getArrPaneles() {
        return arrPaneles;
    }

    public void setArrPaneles(JPanel[] arrPaneles) {
        this.arrPaneles = arrPaneles;
    }

    public Nota[] getArrNotas() {
        return arrNotas;
    }

    public void setArrNotas(Nota[] arrNotas) {
        this.arrNotas = arrNotas;
    }

    public int getNotasCreadas() {
        return notasCreadas;
    }

    public void setNotasCreadas(int notasCreadas) {
        this.notasCreadas = notasCreadas;
    }

    public int getNumeroContenedor() {
        return numeroContenedor;
    }

    public void setNumeroContenedor(int numeroContenedor) {
        this.numeroContenedor = numeroContenedor;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertarNota = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        panel5 = new javax.swing.JPanel();
        panel6 = new javax.swing.JPanel();
        eliminarContenedor = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        crearContenedor = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertarNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/alta.png"))); // NOI18N
        insertarNota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        insertarNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertarNotaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insertarNotaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                insertarNotaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                insertarNotaMouseReleased(evt);
            }
        });
        add(insertarNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 68, 70));

        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        panel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        add(panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        panel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        panel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, -1, -1));

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
        add(eliminarContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 80, 60));

        panel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

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
        add(crearContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 68, 70));
    }// </editor-fold>//GEN-END:initComponents

    private void insertarNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarNotaMouseClicked
      
        if(notasCreadas<6){  
          Nota nota = new Nota(panel1, this);
          Notas.insertarNota(this.getArrPaneles()[nota.getPosicion()],nota,this);
        }else{
           JOptionPane.showMessageDialog(null,"No se pueden insertar más de 6 notas","",JOptionPane.WARNING_MESSAGE);
        }
 
    }//GEN-LAST:event_insertarNotaMouseClicked

    private void insertarNotaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarNotaMousePressed
        insertarNota.setEnabled(false);
    }//GEN-LAST:event_insertarNotaMousePressed

    private void insertarNotaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarNotaMouseExited

        insertarNota.setEnabled(true);
      
    }//GEN-LAST:event_insertarNotaMouseExited

    private void insertarNotaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertarNotaMouseReleased
        insertarNota.setEnabled(true);
    }//GEN-LAST:event_insertarNotaMouseReleased

    private void eliminarContenedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarContenedorMouseClicked
        tNotas.eliminarContenedor(this);
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
               tNotas.crearContenedor();
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
    private javax.swing.JLabel insertarNota;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    // End of variables declaration//GEN-END:variables
}
