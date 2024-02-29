package BusinessLogic.Entities.AntBot;

public class RadioComunicacion {
    private  int frecuencia;
    private String  modeloRadio;
    public RadioComunicacion(){
        this.frecuencia=100;
        this.modeloRadio= "Estándar";
    }
    public int getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    public String getModeloRadio() {
        return modeloRadio;
    }
    public void setModeloRadio(String modeloRadio) {
        this.modeloRadio = modeloRadio;
    }
}
