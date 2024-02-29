package BusinessLogic.Entities.Personal;

import BusinessLogic.Entities.AntBot.ITenicoIngles;

public class ExpertoIngles extends Humano {
    public ExpertoIngles(String nombre) {
        super(nombre);

    }

    public boolean ensenarRuso(ITenicoIngles TecnicoIngles) {
        System.out.println("Enseñando Ingles");
        return true;
    }
}
