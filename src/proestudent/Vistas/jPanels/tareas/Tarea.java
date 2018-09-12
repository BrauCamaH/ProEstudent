
package proestudent.Vistas.jPanels.tareas;


import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proestudent.Vistas.jFrames.tareas.ModificarTarea;
import proestudent.clases.Materia;
import proestudent.clases.Tareas;

public class Tarea extends javax.swing.JPanel {
    private String titulo;
    private String contenido;
    private Materia materia;
    private String fecha;
    
    private JPanel panelPadre;
    private  ContenedorTareas contenedor;
    private final int posicion;
    public Tarea(JPanel panel,ContenedorTareas cTarea) {
        initComponents();
        panelPadre=panel;
        contenedor=cTarea;
        contenedor.setTareasCreadas(contenedor.getTareasCreadas()+1);
        posicion=contenedor.buscarEspacioVacio(contenedor);
        
        jProfesor.setVisible(false);
        jDiasFaltantes.setVisible(false);
    }
    public void prioridad(int prioridad){
        Color amarillo = new Color(248,243,53);
        Color verde = new Color(189,236,182);
        Color Rojo = new Color(197,29,52);
        switch(prioridad){
            case 1:
                this.jPrioridad.setText("Prioridad Alta");
                this.jPrioridad.setBackground(Rojo);
            break;
            case 2:
                this.jPrioridad.setText("Prioridad Media");
                this.jPrioridad.setBackground(amarillo);
            break;
            case 3:
                this.jPrioridad.setText("Prioridad Baja");
                this.jPrioridad.setBackground(verde);
            break;
        }
    }
    public int obtenerDiasFaltantes (String fecha){
        Calendar calendario1 = new GregorianCalendar();
        Calendar calendario2 = new GregorianCalendar();
        Date fechaActual = new Date();
        Date fechaEntrega = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            fechaEntrega=dateFormat.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        calendario1.setTime(fechaActual);
        calendario2.setTime(fechaEntrega);
        return calendario2.get(Calendar.DAY_OF_YEAR)-calendario1.get(Calendar.DAY_OF_YEAR);
    }
    public void mostrarColorEnDiasFaltantes (int diferencia){
        Color rojo = new Color(165,32,025);
        Color verde= new Color(28,84,45);
        Color naranja = new Color(255,164,032);
       if(diferencia < 0){
           diasFaltantes.setBackground(Color.black);
           this.jDiasFaltantes.setText("La tarea ha finalizado");
       }else if(diferencia == 0 || diferencia ==1){
           diasFaltantes.setBackground(rojo);
           if(diferencia==0){
              this.jDiasFaltantes.setText("La tarea es para hoy"); 
           }else{
              this.jDiasFaltantes.setText("La tarea es para mañana");
           }
       }else if(diferencia <=3){
           diasFaltantes.setBackground(naranja);
           this.jDiasFaltantes.setText("Faltan: "+ diferencia+" días");
       }else{
           diasFaltantes.setBackground(verde);
           this.jDiasFaltantes.setText("Faltan: "+ diferencia+" días");
       }

    }
    public void setDatosDeMateria(Materia materia){
        this.materia= materia;
        this.jProfesor.setText(this.materia.getNombreProfesor());
        this.jMateria.setText(this.materia.getNombreMateria());
        this.prioridad(materia.getPrioridad());
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
        this.jlFecha.setText("Entregar: "+ fecha);
    }
    public String getFecha(){
        return fecha;
    }
     public int getPosicion(){
        return posicion;
    }
     
    public String getTitulo() {
        titulo = this.jTitulo.getText();
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
       this.jTitulo.setText(this.titulo);
    }

    public String getContenido() {
        contenido = this.jContenido.getText();
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
        this.jContenido.setText(this.contenido);
    }


    public JPanel getPanelPadre() {
        return panelPadre;
    }

    public void setPanelPadre(JPanel panelPadre) {
        this.panelPadre = panelPadre;
    }

    public ContenedorTareas getContenedor() {
        return contenedor;
    }

    public void setContenedor(ContenedorTareas contenedor) {
        this.contenedor = contenedor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProfesor = new javax.swing.JLabel();
        configuracion = new javax.swing.JLabel();
        jDiasFaltantes = new javax.swing.JLabel();
        equis = new javax.swing.JLabel();
        jTitulo = new javax.swing.JTextField();
        diasFaltantes = new javax.swing.JTextField();
        jMateria = new javax.swing.JTextField();
        jPrioridad = new javax.swing.JTextField();
        barraSuperior = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jContenido = new javax.swing.JTextArea();
        jlFecha = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProfesor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jProfesor.setText("Nombre Profesor");
        jProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 270, 20));

        configuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/engranaje.png"))); // NOI18N
        configuracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configuracionMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                configuracionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                configuracionMousePressed(evt);
            }
        });
        add(configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jDiasFaltantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDiasFaltantes.setText("jDiasFaltantes");
        jDiasFaltantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jDiasFaltantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 160, 20));

        equis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/equis.png"))); // NOI18N
        equis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equisMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                equisMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                equisMousePressed(evt);
            }
        });
        add(equis, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jTitulo.setBackground(new java.awt.Color(153, 153, 153));
        jTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTitulo.setText("Titulo");
        jTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTituloActionPerformed(evt);
            }
        });
        add(jTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        diasFaltantes.setEditable(false);
        diasFaltantes.setBackground(new java.awt.Color(102, 102, 102));
        diasFaltantes.setForeground(new java.awt.Color(255, 255, 102));
        diasFaltantes.setFocusable(false);
        diasFaltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diasFaltantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                diasFaltantesMouseExited(evt);
            }
        });
        diasFaltantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasFaltantesActionPerformed(evt);
            }
        });
        add(diasFaltantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 320));

        jMateria.setEditable(false);
        jMateria.setBackground(new java.awt.Color(255, 255, 255));
        jMateria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMateria.setForeground(new java.awt.Color(102, 51, 0));
        jMateria.setFocusable(false);
        jMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMateriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMateriaMouseExited(evt);
            }
        });
        add(jMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 290, 30));

        jPrioridad.setEditable(false);
        jPrioridad.setBackground(new java.awt.Color(153, 153, 255));
        jPrioridad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPrioridad.setForeground(new java.awt.Color(255, 255, 255));
        jPrioridad.setFocusable(false);
        add(jPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 140, 40));

        barraSuperior.setEditable(false);
        barraSuperior.setBackground(new java.awt.Color(153, 153, 153));
        barraSuperior.setFocusable(false);
        barraSuperior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraSuperiorActionPerformed(evt);
            }
        });
        add(barraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 40));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jContenido.setBackground(new java.awt.Color(204, 204, 204));
        jContenido.setColumns(20);
        jContenido.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jContenido.setForeground(new java.awt.Color(51, 51, 255));
        jContenido.setLineWrap(true);
        jContenido.setRows(5);
        jScrollPane1.setViewportView(jContenido);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 290, 220));

        jlFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlFecha.setText("Fecha de entrega");
        add(jlFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/gris.jpg"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 320));
    }// </editor-fold>//GEN-END:initComponents

    private void diasFaltantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasFaltantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diasFaltantesActionPerformed

    private void barraSuperiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraSuperiorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barraSuperiorActionPerformed

    private void equisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equisMouseClicked
        int opcion=JOptionPane.showConfirmDialog(this, "¿Desea eliminar la Tarea?", "Mensaje de confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (opcion==0) {   
            Tareas.destruir(this,contenedor);
            System.out.println("tarea destruida");
            panelPadre.updateUI();
         }
    }//GEN-LAST:event_equisMouseClicked

    private void equisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equisMouseExited
        equis.setEnabled(true);
    }//GEN-LAST:event_equisMouseExited

    private void equisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equisMousePressed
        equis.setEnabled(false);
    }//GEN-LAST:event_equisMousePressed

    private void configuracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuracionMouseClicked
        ModificarTarea mt = new ModificarTarea(this);
        mt.setVisible(true);
    }//GEN-LAST:event_configuracionMouseClicked

    private void configuracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuracionMouseExited
        configuracion.setEnabled(true);
    }//GEN-LAST:event_configuracionMouseExited

    private void configuracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuracionMousePressed
        configuracion.setEnabled(false);
    }//GEN-LAST:event_configuracionMousePressed

    private void jTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTituloActionPerformed

    private void jMateriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMateriaMouseEntered
         try {
            Thread.sleep(1250);
            jContenido.setEnabled(false);
            jContenido.setEnabled(true);
            jProfesor.setVisible(true);
            
        }catch(InterruptedException e) {
        
        }
    }//GEN-LAST:event_jMateriaMouseEntered

    private void jMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMateriaMouseExited
        jProfesor.setVisible(false);
    }//GEN-LAST:event_jMateriaMouseExited

    private void diasFaltantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diasFaltantesMouseEntered
         try {
            Thread.sleep(1250);
            jContenido.setEnabled(false);
            jContenido.setEnabled(true);
            jDiasFaltantes.setVisible(true);
        }catch(InterruptedException e) {
        
        }
    }//GEN-LAST:event_diasFaltantesMouseEntered

    private void diasFaltantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diasFaltantesMouseExited
            jDiasFaltantes.setVisible(false);
    }//GEN-LAST:event_diasFaltantesMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraSuperior;
    private javax.swing.JLabel configuracion;
    private javax.swing.JTextField diasFaltantes;
    private javax.swing.JLabel equis;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextArea jContenido;
    private javax.swing.JLabel jDiasFaltantes;
    private javax.swing.JTextField jMateria;
    private javax.swing.JTextField jPrioridad;
    private javax.swing.JLabel jProfesor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTitulo;
    private javax.swing.JLabel jlFecha;
    // End of variables declaration//GEN-END:variables
}
