package BusinessLogic.Entities.Personal;

import BusinessLogic.Entities.AntBot.ITecnicoRuso;

public class ExpertoRuso extends Humano  {
    public ExpertoRuso(String nombre) {
        super(nombre);

    }
    public boolean ensenarRuso(ITecnicoRuso tecnicoRuso){
        
        System.out.println("Enseñando Ruso");
        return true;
    }
}
