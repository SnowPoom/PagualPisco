package BusinessLogic.Entities.AntBot;

public class Procesador {
    private String modelo;
    private String  velocidadCpu;
    public Procesador(){
        this.modelo = "Kidin9100";
        this.velocidadCpu="4GHz";
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getVelocidadCpu() {
        return velocidadCpu;
    }
    public void setVelocidadCpu(String velocidadCpu) {
        this.velocidadCpu = velocidadCpu;
    }
}
