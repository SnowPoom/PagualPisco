package BusinessLogic.Entities.Personal;

public abstract class Humano {
    private String nombre;
    public Humano(String nombre){
        this.nombre=nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
