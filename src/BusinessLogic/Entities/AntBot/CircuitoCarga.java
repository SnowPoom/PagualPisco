package BusinessLogic.Entities.AntBot;

public class CircuitoCarga {
    
    private String  nombreCircuito;
    private int corrienteCircuito;
    public CircuitoCarga(){
        this.corrienteCircuito=200;
        this.nombreCircuito="Circuito de AntBot";
    }
    public String getNombreCircuito() {
        return nombreCircuito;
    }
    public void setNombreCircuito(String nombreCircuito) {
        this.nombreCircuito = nombreCircuito;
    }
    public int getCorrienteCircuito() {
        return corrienteCircuito;
    }
    public void setCorrienteCircuito(int corrienteCircuito) {
        this.corrienteCircuito = corrienteCircuito;
    }
}
