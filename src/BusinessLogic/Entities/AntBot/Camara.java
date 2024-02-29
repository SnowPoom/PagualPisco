package BusinessLogic.Entities.AntBot;

public class Camara {
    private String modelo;
    private boolean estadoActivo;
    public Camara(){
        this.modelo = "V2024";
        this.estadoActivo=true;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public boolean isEstadoActivo() {
        return estadoActivo;
    }
    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

}
