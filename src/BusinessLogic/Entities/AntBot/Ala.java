package BusinessLogic.Entities.AntBot;

public class Ala {
    private  int numAlas;
    public Ala(){
        this.numAlas=2;
    }
    public String volar(){
        return "Volando";
    }
    public int getNumAlas() {
        return numAlas;
    }
    public void setNumAlas(int numAlas) {
        this.numAlas = numAlas;
    }
     
}
