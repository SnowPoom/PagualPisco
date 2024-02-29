package BusinessLogic.Entities.ProcesoReina;

import java.util.ArrayList;
import java.util.List;

import BusinessLogic.PPLectorArchivo;
import BusinessLogic.Entities.Hormiga.Hormiga;

public class PPProcesoReina {

    private Hormiga ppReina=new Hormiga(1);
    private List<Hormiga> pplarvas;

    private List<String> ppAlimentoInicio;
    public PPProcesoReina() throws Exception{
        pplarvas=new ArrayList<>();
        ppAlimentoInicio=PPLectorArchivo.ppReadFile();
    }
    public void ppAlimentarLarvas(){
       for(int i=0 ;i<40;i++){
        if(ppAlimentoInicio.get(i).equals("Carnivoro")){
            pplarvas.get(i).comer(new PPCarnivoro());
            pplarvas.get(i).setIdClasificacion(1);
            ppAlimentoInicio.remove(i);
        }
        pplarvas.remove(i);
    }

    }
    public void ppBuscando(){
        for(int i =0;i<pplarvas.size();i++){
            if(ppAlimentoInicio.get(i).equals("Carnivoro")){
                pplarvas.get(i).comer(new PPCarnivoro());
            }
            pplarvas.remove(i);
        }
    }
}
