package BusinessLogic.Entities.AntBot;

public class Tronco {
    private int  longitud;
    private int alto;
    private int ancho;
    private Ala alas;
    public Tronco(){
        this.longitud = 20;
        this.alto=5;
        this.ancho=5; 
    }
    public void agregarAlas(boolean clasificacionAceptada){
        if(clasificacionAceptada){
            alas= new Ala();
        }
    }
    public Ala getAlas() {
        return alas;
    }
    public void setAlas(Ala alas) {
        this.alas = alas;
    }
    public int getLongitud() {
        return longitud;
    }
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
   
}
