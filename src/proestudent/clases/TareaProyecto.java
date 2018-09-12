
package proestudent.clases;
/**
 *
 * @author ACER
 */
public class TareaProyecto {
    private String tarea;
    private String descripción;
    private int columna;
    
    public void copiarTareaProyecto(TareaProyecto tarea){
        this.setTarea(tarea.getTarea());
        this.setDescripción(tarea.getDescripción());
        this.setTarea(tarea.getTarea());
    }
    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getColumna() {
        System.out.println("columna"+ columna);
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}
