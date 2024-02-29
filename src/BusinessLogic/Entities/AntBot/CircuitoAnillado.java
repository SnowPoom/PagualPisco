package BusinessLogic.Entities.AntBot;

public class CircuitoAnillado {
    private int salida;
    private String  nombreCircuito;
    public CircuitoAnillado(){
        this.salida=300;
        this.nombreCircuito="CircuitoAntBot";
    }
    public int getSalidaVol() {
        return salida;
    }
    public void setSalidaVol(int salida) {
        this.salida = salida;
    }
    public String getNombreCircuito() {
        return nombreCircuito;
    }
    public void setNombreCircuito(String nombreCircuito) {
        this.nombreCircuito = nombreCircuito;
    }
}
