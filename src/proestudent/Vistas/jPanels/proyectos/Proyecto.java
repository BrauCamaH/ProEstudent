
package proestudent.Vistas.jPanels.proyectos;

import proestudent.Vistas.jPanels.proyectos.TabProyectos;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proestudent.Vistas.jFrames.proyectos.CrearTareaProyecto;
import proestudent.clases.TareaProyecto;

public class Proyecto extends javax.swing.JPanel {
    private final TabProyectos tabProyecto;
    private String nombre;
    private int tablaHaInsertar;
    private int id;
    //lista que contiene la referencia de todas las tareas del proyecto en la tabla
    private  LinkedList <TareaProyecto> listaTareasProyecto;
    
    private final LinkedList <TareaProyecto> tareasPorHacer;
    private final LinkedList <TareaProyecto> tareasHaciendo;
    private final LinkedList <TareaProyecto> tareasFinalizadas;
    
    public final static int COLUMNA_PORHACER=1;
    public final static int COLUMNA_HACIENDO=2;
    public final static int COLUMNA_FINALIZADAS= 3;
        public Proyecto(TabProyectos tPane, int id) {
        initComponents();
        this.tabProyecto = tPane;
        tareasPorHacer = new <TareaProyecto>LinkedList();
        tareasHaciendo = new <TareaProyecto>LinkedList();
        tareasFinalizadas = new <TareaProyecto>LinkedList();
        
        this.listaTareasProyecto = new <TareaProyecto> LinkedList();
        this.id= id;
        
    }
    public Proyecto(TabProyectos tPane) {
        initComponents();
        this.tabProyecto = tPane;
        tareasPorHacer = new <TareaProyecto>LinkedList();
        tareasHaciendo = new <TareaProyecto>LinkedList();
        tareasFinalizadas = new <TareaProyecto>LinkedList();
        
        this.listaTareasProyecto = new <TareaProyecto> LinkedList();
        
    }
    
    public void modificarNombre(){
      try{  String nProyecto;
        nProyecto = JOptionPane.showInputDialog(this, "Ingrese Nuevo Nombre del Proyecto","Cambiar Nombre",JOptionPane.PLAIN_MESSAGE);
        if(!nProyecto.isEmpty()){
            this.setNombreProyecto(nProyecto);
            jToggle.setSelected(false);
         }else{
            jToggle.setSelected(false);
        }
      }catch (NullPointerException npe){
            jToggle.setSelected(false);
      }
    }
    private void actualizarTareasProyecto(){
        
        tareasPorHacer.forEach((tarea) -> {
            this.listaTareasProyecto.addLast(tarea);
        });
        tareasHaciendo.forEach((tarea) -> {
            this.listaTareasProyecto.addLast(tarea);
        });
        tareasFinalizadas.forEach((tarea) -> {
            this.listaTareasProyecto.addLast(tarea);
        });
    }
    private void mostrarDatosLista(LinkedList<TareaProyecto> lista){
        for(TareaProyecto tproyecto : lista){
            System.out.println(tproyecto.getTarea());
        }
    }
    public LinkedList<TareaProyecto> getListaTareasProyecto() {
        this.listaTareasProyecto.clear();
        this.actualizarTareasProyecto();
        this.mostrarDatosLista(listaTareasProyecto);
        return listaTareasProyecto;
    }
    
    
  
    public TareaProyecto crearTarea(int columna){
        TareaProyecto tareaProyecto = new TareaProyecto();
        switch(columna){
            case 1:
                tareasPorHacer.addLast(tareaProyecto);
            break;
            case 2:
                tareasHaciendo.addLast(tareaProyecto);
            break;
            case 3:
                tareasFinalizadas.addLast(tareaProyecto);
            break;
            default:
                JOptionPane.showMessageDialog(this,"No existe esa columna","Error",JOptionPane.ERROR_MESSAGE);
            break;
        }
        return tareaProyecto;
    }

    public void mostrarDescripcion(JTable tabla,int columna){   
        int selectedRow = tabla.getSelectedRow();
        switch(columna){
            case 1: 
                descripcion.setText(tareasPorHacer.get(selectedRow).getDescripción());
            break;
            case 2:
                 descripcion.setText(tareasHaciendo.get(selectedRow).getDescripción());
            break;
            case 3:
                 descripcion.setText(tareasFinalizadas.get(selectedRow).getDescripción());
            break;  
        }
    }
    public void agregarTarea(int columna, TareaProyecto tarea){
        DefaultTableModel modelo;
        Object [] fila; 
       switch(columna){
            case 1:
                modelo=(DefaultTableModel) porHacer.getModel();
                fila = new Object[1];
                fila[0]=tarea.getTarea();
                modelo.addRow(fila); 
                porHacer.setModel(modelo); 
            break;
            case 2:
                modelo=(DefaultTableModel) haciendo.getModel();
                fila = new Object[1];
                fila[0]=tarea.getTarea();
                modelo.addRow(fila); 
                haciendo.setModel(modelo); 
            break;
            case 3:
                modelo=(DefaultTableModel) finalizadas.getModel();
                fila = new Object[1];
                fila[0]=tarea.getTarea();
                modelo.addRow(fila); 
                finalizadas.setModel(modelo); 
            break;  
        }
    }
    public void eliminarTarea(JTable tabla){
        DefaultTableModel modelo=(DefaultTableModel) tabla.getModel(); 
        int fila = tabla.getSelectedRow();
        modelo.removeRow(fila);
        descripcion.setText("");
        System.out.println(""+fila);
         if(tabla.equals(this.porHacer)){
            tareasPorHacer.remove(fila);
             System.out.println("tamaño lista por hacer"+ tareasPorHacer.size());
                 this.mostrarDatosLista(tareasPorHacer);
         }
        if(tabla.equals(this.haciendo)){
             tareasHaciendo.remove(fila);
             System.out.println("tamaño lista haciendo"+ tareasHaciendo.size());
        }
        if(tabla.equals(this.finalizadas)){
             this.tareasFinalizadas.remove(fila);
             System.out.println("tamaño lista finalizadas"+ tareasFinalizadas.size());
        }
    
    
    }
    public void cambiarTarea(JTable tabla,int nuevaColumna ,LinkedList <TareaProyecto>  listaTarea){
    int selectedRow = tabla.getSelectedRow();
    TareaProyecto tarea = this.crearTarea(nuevaColumna);
    TareaProyecto inicial = listaTarea.get(selectedRow);
    tarea.copiarTareaProyecto(inicial);
    tarea.setColumna(nuevaColumna);
    this.agregarTarea(tarea.getColumna(),tarea);
    this.eliminarTarea(tabla);
    if(tabla.equals(this.porHacer)){
        eliminarPorHacer.setEnabled(false);
        porHacerDer.setEnabled(false);
    }else if(tabla.equals(this.haciendo)){
        eliminarHaciendo.setEnabled(false);
        this.haciendoDer.setEnabled(false);
        this.haciendoIzq.setEnabled(false);
    }else{
        eliminarFinalizadas.setEnabled(false);
        this.finalizadasIzq.setEnabled(false);
    }
    
}
    public JButton obtenerBotonEliminar(){
        return this.eliminarProyecto;
    }
    public int getTablaHaInsertar() {
        return tablaHaInsertar;
    }
    
    public void setTablaHaInsertar(int tablaHaInsertar) {
        this.tablaHaInsertar = tablaHaInsertar;
    }
    public String  getNombreProyecto(){
        return this.nombre;
    }
    public void setNombreProyecto(String nombre){
        this.nombre=nombre;
        this.nombreProyecto.setText(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        finalizadas = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        porHacer = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        haciendo = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        eliminarFinalizadas = new javax.swing.JButton();
        agregarHaciendo = new javax.swing.JButton();
        agregarFinalizadas = new javax.swing.JButton();
        eliminarPorHacer = new javax.swing.JButton();
        agregarPorHacer = new javax.swing.JButton();
        finalizadasIzq = new javax.swing.JButton();
        nombreProyecto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        eliminarHaciendo = new javax.swing.JButton();
        porHacerDer = new javax.swing.JButton();
        haciendoDer = new javax.swing.JButton();
        haciendoIzq = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        eliminarProyecto = new javax.swing.JButton();
        jToggle = new javax.swing.JToggleButton();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        finalizadas.setBackground(new java.awt.Color(0, 102, 0));
        finalizadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        finalizadas.setForeground(new java.awt.Color(255, 255, 255));
        finalizadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                         Finalizadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        finalizadas.setColumnSelectionAllowed(true);
        finalizadas.setSelectionBackground(new java.awt.Color(0, 153, 0));
        finalizadas.getTableHeader().setReorderingAllowed(false);
        finalizadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalizadasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(finalizadas);
        finalizadas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 260, 320));

        porHacer.setBackground(new java.awt.Color(153, 0, 0));
        porHacer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        porHacer.setForeground(new java.awt.Color(255, 255, 255));
        porHacer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                         Por Hacer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        porHacer.setColumnSelectionAllowed(true);
        porHacer.setDropMode(javax.swing.DropMode.ON);
        porHacer.setSelectionBackground(new java.awt.Color(204, 0, 0));
        porHacer.getTableHeader().setReorderingAllowed(false);
        porHacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                porHacerMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                porHacerMouseExited(evt);
            }
        });
        jScrollPane7.setViewportView(porHacer);
        porHacer.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 260, 320));

        haciendo.setBackground(new java.awt.Color(255, 102, 0));
        haciendo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        haciendo.setForeground(new java.awt.Color(255, 255, 255));
        haciendo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                           Haciendo                       "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        haciendo.setColumnSelectionAllowed(true);
        haciendo.setSelectionBackground(new java.awt.Color(255, 153, 0));
        haciendo.getTableHeader().setReorderingAllowed(false);
        haciendo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                haciendoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(haciendo);
        haciendo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 260, 320));

        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        descripcion.setLineWrap(true);
        descripcion.setRows(5);
        descripcion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        descripcion.setEnabled(false);
        jScrollPane1.setViewportView(descripcion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 510, 180));

        eliminarFinalizadas.setBackground(new java.awt.Color(204, 204, 204));
        eliminarFinalizadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/eliminarTareaP.png"))); // NOI18N
        eliminarFinalizadas.setEnabled(false);
        eliminarFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarFinalizadasActionPerformed(evt);
            }
        });
        add(eliminarFinalizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 40, 30));

        agregarHaciendo.setBackground(new java.awt.Color(204, 204, 204));
        agregarHaciendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/agregarTareaP.png"))); // NOI18N
        agregarHaciendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarHaciendoActionPerformed(evt);
            }
        });
        add(agregarHaciendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 40, 30));

        agregarFinalizadas.setBackground(new java.awt.Color(204, 204, 204));
        agregarFinalizadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/agregarTareaP.png"))); // NOI18N
        agregarFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFinalizadasActionPerformed(evt);
            }
        });
        add(agregarFinalizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 40, 30));

        eliminarPorHacer.setBackground(new java.awt.Color(204, 204, 204));
        eliminarPorHacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/eliminarTareaP.png"))); // NOI18N
        eliminarPorHacer.setEnabled(false);
        eliminarPorHacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPorHacerActionPerformed(evt);
            }
        });
        add(eliminarPorHacer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 40, 30));

        agregarPorHacer.setBackground(new java.awt.Color(204, 204, 204));
        agregarPorHacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/agregarTareaP.png"))); // NOI18N
        agregarPorHacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPorHacerActionPerformed(evt);
            }
        });
        add(agregarPorHacer, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 40, 30));

        finalizadasIzq.setBackground(new java.awt.Color(204, 204, 204));
        finalizadasIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/flechaIzq.png"))); // NOI18N
        finalizadasIzq.setEnabled(false);
        finalizadasIzq.setFocusPainted(false);
        finalizadasIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizadasIzqActionPerformed(evt);
            }
        });
        add(finalizadasIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 40, 30));

        nombreProyecto.setBackground(new java.awt.Color(204, 204, 204));
        nombreProyecto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nombreProyecto.setForeground(new java.awt.Color(51, 51, 51));
        nombreProyecto.setText("Nombre Del Proyecto");
        add(nombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 770, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Descripción ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText(" de Tarea");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 140, 20));

        eliminarHaciendo.setBackground(new java.awt.Color(204, 204, 204));
        eliminarHaciendo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/eliminarTareaP.png"))); // NOI18N
        eliminarHaciendo.setEnabled(false);
        eliminarHaciendo.setFocusPainted(false);
        eliminarHaciendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarHaciendoActionPerformed(evt);
            }
        });
        add(eliminarHaciendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 40, 30));

        porHacerDer.setBackground(new java.awt.Color(204, 204, 204));
        porHacerDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/flechaDerecha.png"))); // NOI18N
        porHacerDer.setEnabled(false);
        porHacerDer.setFocusPainted(false);
        porHacerDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porHacerDerActionPerformed(evt);
            }
        });
        add(porHacerDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 40, 30));

        haciendoDer.setBackground(new java.awt.Color(204, 204, 204));
        haciendoDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/flechaDerecha.png"))); // NOI18N
        haciendoDer.setEnabled(false);
        haciendoDer.setFocusPainted(false);
        haciendoDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haciendoDerActionPerformed(evt);
            }
        });
        add(haciendoDer, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 40, 30));

        haciendoIzq.setBackground(new java.awt.Color(204, 204, 204));
        haciendoIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/flechaIzq.png"))); // NOI18N
        haciendoIzq.setEnabled(false);
        haciendoIzq.setFocusPainted(false);
        haciendoIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haciendoIzqActionPerformed(evt);
            }
        });
        add(haciendoIzq, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 40, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/proyecto.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 560, 100, 90));

        eliminarProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/eliminar.png"))); // NOI18N
        eliminarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProyectoActionPerformed(evt);
            }
        });
        add(eliminarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 80, 70));

        jToggle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/engranaje.png"))); // NOI18N
        jToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleActionPerformed(evt);
            }
        });
        add(jToggle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 40, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void agregarPorHacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPorHacerActionPerformed
        tablaHaInsertar=Proyecto.COLUMNA_PORHACER;
        CrearTareaProyecto nuevaTarea = new CrearTareaProyecto(this);
        nuevaTarea.setVisible(true);
    }//GEN-LAST:event_agregarPorHacerActionPerformed

    private void eliminarPorHacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPorHacerActionPerformed
       this.eliminarTarea(porHacer);
       eliminarPorHacer.setEnabled(false);
       porHacerDer.setEnabled(false);
    }//GEN-LAST:event_eliminarPorHacerActionPerformed

    private void porHacerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_porHacerMouseClicked
        this.mostrarDescripcion(porHacer,Proyecto.COLUMNA_PORHACER);
        eliminarPorHacer.setEnabled(true);
         porHacerDer.setEnabled(true);

    }//GEN-LAST:event_porHacerMouseClicked

    private void porHacerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_porHacerMouseExited

    }//GEN-LAST:event_porHacerMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
    }//GEN-LAST:event_formKeyPressed

    private void agregarHaciendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarHaciendoActionPerformed
        tablaHaInsertar=Proyecto.COLUMNA_HACIENDO;
        CrearTareaProyecto nuevaTarea = new CrearTareaProyecto(this);
        nuevaTarea.setVisible(true);
    }//GEN-LAST:event_agregarHaciendoActionPerformed

    private void finalizadasIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizadasIzqActionPerformed
        this.cambiarTarea(finalizadas,Proyecto.COLUMNA_HACIENDO, tareasFinalizadas);
    }//GEN-LAST:event_finalizadasIzqActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
      
    }//GEN-LAST:event_formKeyTyped

    private void agregarFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFinalizadasActionPerformed
       tablaHaInsertar=Proyecto.COLUMNA_FINALIZADAS;
        CrearTareaProyecto nuevaTarea = new CrearTareaProyecto(this);
        nuevaTarea.setVisible(true);
    }//GEN-LAST:event_agregarFinalizadasActionPerformed

    private void eliminarFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFinalizadasActionPerformed
         this.eliminarTarea(finalizadas);
        eliminarFinalizadas.setEnabled(false);
    }//GEN-LAST:event_eliminarFinalizadasActionPerformed

    private void haciendoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_haciendoMouseClicked
        eliminarHaciendo.setEnabled(true);
        this.haciendoDer.setEnabled(true);
        this.haciendoIzq.setEnabled(true);
        this.mostrarDescripcion(haciendo, Proyecto.COLUMNA_HACIENDO);
    }//GEN-LAST:event_haciendoMouseClicked

    private void finalizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizadasMouseClicked
        eliminarFinalizadas.setEnabled(true);
        this.finalizadasIzq.setEnabled(true);
        this.mostrarDescripcion(finalizadas, Proyecto.COLUMNA_FINALIZADAS);
    }//GEN-LAST:event_finalizadasMouseClicked

    private void eliminarHaciendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarHaciendoActionPerformed
        this.eliminarTarea(haciendo);
        eliminarHaciendo.setEnabled(false);
    }//GEN-LAST:event_eliminarHaciendoActionPerformed

    private void porHacerDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porHacerDerActionPerformed
        this.cambiarTarea(porHacer,Proyecto.COLUMNA_HACIENDO, tareasPorHacer);
    }//GEN-LAST:event_porHacerDerActionPerformed

    private void haciendoDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haciendoDerActionPerformed
        this.cambiarTarea(haciendo,Proyecto.COLUMNA_FINALIZADAS,tareasHaciendo);
    }//GEN-LAST:event_haciendoDerActionPerformed

    private void haciendoIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haciendoIzqActionPerformed
        this.cambiarTarea(haciendo,Proyecto.COLUMNA_PORHACER,tareasHaciendo);
    }//GEN-LAST:event_haciendoIzqActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.tabProyecto.crearNuevoProyecto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eliminarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProyectoActionPerformed
        this.tabProyecto.eliminarProyecto(this);
       
        this.tabProyecto.getPrincipal().verificarProyectos();
    }//GEN-LAST:event_eliminarProyectoActionPerformed

    private void jToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleActionPerformed
        this.modificarNombre();
    }//GEN-LAST:event_jToggleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFinalizadas;
    private javax.swing.JButton agregarHaciendo;
    private javax.swing.JButton agregarPorHacer;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JButton eliminarFinalizadas;
    private javax.swing.JButton eliminarHaciendo;
    private javax.swing.JButton eliminarPorHacer;
    private javax.swing.JButton eliminarProyecto;
    private javax.swing.JTable finalizadas;
    private javax.swing.JButton finalizadasIzq;
    private javax.swing.JTable haciendo;
    private javax.swing.JButton haciendoDer;
    private javax.swing.JButton haciendoIzq;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JToggleButton jToggle;
    private javax.swing.JLabel nombreProyecto;
    private javax.swing.JTable porHacer;
    private javax.swing.JButton porHacerDer;
    // End of variables declaration//GEN-END:variables
}
