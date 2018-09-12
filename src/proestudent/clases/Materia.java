package proestudent.clases;

public class Materia {
    private String nombreMateria;
    private final Profesor profesor;
    private int prioridad;
    private int id;
    
    public Materia(Profesor profesor, String nMateria,  int prioridad){
       this.profesor=profesor;
       this.nombreMateria=nMateria;
       this.prioridad=prioridad;
    }
    
    public String getNombreProfesor() {
        return profesor.getNombre();
    }

   
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }
    
    
}
