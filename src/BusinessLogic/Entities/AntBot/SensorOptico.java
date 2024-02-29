package BusinessLogic.Entities.AntBot;

public class SensorOptico {
    private int rangoSensor;
    private boolean  estadoSensor;
    public SensorOptico(){
        rangoSensor=200;
        estadoSensor=true;
    }
    public int getRangoSensor() {
        return rangoSensor;
    }
    public void setRangoSensor(int rangoSensor) {
        this.rangoSensor = rangoSensor;
    }
    public boolean isEstadoSensor() {
        return estadoSensor;
    }
    public void setEstadoSensor(boolean estadoSensor) {
        this.estadoSensor = estadoSensor;
    }
}
