package BusinessLogic.Entities.AntBot;

public class AntenaContacto {
    
    private int largo;
    private String  direccionIp;
    public AntenaContacto(){
        this.largo = 1;
        this.direccionIp ="12.24.8";
    }
    public int getLargo() {
        return largo;
    }
    public void setLargo(int largo) {
        this.largo = largo;
    }
    public String getDireccionIp() {
        return direccionIp;
    }
    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

}
