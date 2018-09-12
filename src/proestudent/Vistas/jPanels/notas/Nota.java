
package proestudent.Vistas.jPanels.notas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proestudent.Conexion;
import proestudent.ProEstudent;
import proestudent.clases.Notas;

public class Nota extends javax.swing.JPanel {
    private final JPanel panelPadre;
    private final ContenedorNotas contenedor;
    private int posicion;
    private String tituloNota;
    private String contenidoNota;
    private int id;
    public Nota(JPanel panel,ContenedorNotas cNotas) {
        panelPadre=panel;
        contenedor=cNotas;
        contenedor.setNotasCreadas(contenedor.getNotasCreadas()+1);
        System.out.println(""+contenedor.getNotasCreadas());
        initComponents();
        System.out.println("nota creada");
        posicion= contenedor.buscarEspacioVacio(contenedor);
        
        System.out.println("posicion"+posicion);
        System.out.println("id"+this.id);
    }
    public Nota(JPanel panel,ContenedorNotas cNotas,String titulo, String contenido){
        initComponents();
        panelPadre=panel;
        contenedor=cNotas;
        contenedor.setNotasCreadas(contenedor.getNotasCreadas()+1);
        posicion= contenedor.buscarEspacioVacio(contenedor);
        this.setTituloNota(titulo);
        this.setContenidoNota(contenido);
    }
    public void buscarId(){
        Conexion conexionNota = new Conexion();
        Statement st;
        try {
            st = conexionNota.getConexion().createStatement();
            ResultSet set =st.executeQuery("SELECT id,titulo,contenido FROM notas WHERE usuario ="+ProEstudent.USUARIO);
            while(set.next()){
                if(this.getTitulo().equals(set.getString("titulo"))&&this.getContenidoNota().equals(set.getString("contenido"))){
                    id= set.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JTextField();
        equis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenido = new javax.swing.JTextArea();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(255, 204, 0));
        titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo.setText("Titulo");
        titulo.setFocusCycleRoot(true);
        titulo.setOpaque(false);
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

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
        add(equis, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        contenido.setBackground(new java.awt.Color(255, 255, 51));
        contenido.setColumns(20);
        contenido.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        contenido.setLineWrap(true);
        contenido.setRows(5);
        contenido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(contenido);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 250, 270));

        fondo.setBackground(new java.awt.Color(255, 255, 153));
        fondo.setForeground(new java.awt.Color(255, 255, 153));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proestudent/Imagenes/Amarillo.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 310));
    }// </editor-fold>//GEN-END:initComponents
    public int getPosicion(){
        return posicion;
    }

    public String getTituloNota() {
        tituloNota=titulo.getText();
        return tituloNota;
    }

    private void setTituloNota(String tituloNota) {
       titulo.setText(tituloNota);
    }

    public String getContenidoNota() {
        contenidoNota=contenido.getText();
        return contenidoNota;
    }

    private void setContenidoNota(String contenidoNota) {
        contenido.setText(contenidoNota);
    }
    
    private void equisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equisMouseClicked
            Notas.destruir(this,contenedor);
            System.out.println("nota destruida");
            panelPadre.updateUI();
    }//GEN-LAST:event_equisMouseClicked

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private void equisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equisMouseExited
        equis.setEnabled(true);
    }//GEN-LAST:event_equisMouseExited

    private void equisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equisMousePressed
        equis.setEnabled(false);
    }//GEN-LAST:event_equisMousePressed

    public JTextArea getContenido() {
        return contenido;
    }

    public void setContenido(JTextArea contenido) {
        this.contenido = contenido;
    }

    public JTextField getTitulo() {
        return titulo;
    }

    public void setTitulo(JTextField titulo) {
        this.titulo = titulo;
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea contenido;
    private javax.swing.JLabel equis;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
