package BusinessLogic.Entities.ProcesoReina;

import java.util.ArrayList;
import java.util.List;

import BusinessLogic.PPLectorArchivo;
import BusinessLogic.Entities.Hormiga.Hormiga;

public class PPProcesoReina {

    private Hormiga ppReina=new Hormiga(1);
    private List<Hormiga> pplarvas;

    private List<String> alimentoInicio;
    public PPProcesoReina() throws Exception{
        pplarvas=new ArrayList<>();
        for (Hormiga ppHormiga : pplarvas) {
        }
        alimentoInicio=PPLectorArchivo.ppReadFile();
    }
}
