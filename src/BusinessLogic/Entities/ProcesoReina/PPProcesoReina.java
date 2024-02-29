package BusinessLogic.Entities.ProcesoReina;

import java.util.ArrayList;
import java.util.List;

import BusinessLogic.HormigaBL;
import BusinessLogic.PPLectorArchivo;
import BusinessLogic.Entities.Hormiga.Hormiga;
import DataAccess.DTO.HormigaDTO;

public class PPProcesoReina {

    private Hormiga ppReina=new Hormiga(4);
    private List<Hormiga> pplarvas;
    private HormigaBL ppHormigaBL =new HormigaBL();
    private List<String> ppAlimentoInicio;
    public PPProcesoReina() throws Exception{
        pplarvas=new ArrayList<>();
        ppAlimentoInicio=PPLectorArchivo.ppReadFile();
    }
    public void ppAlimentarLarvas() throws Exception{
       for(int i=0 ;i<40;i++){
        if(ppAlimentoInicio.get(i).equals("Carnivoro")){
            HormigaDTO ppOHormigaDTO=new HormigaDTO();
            ppOHormigaDTO.setCodigo(ppHormigaBL.getCodigoRandom());
            ppOHormigaDTO.setComio(1);
            ppOHormigaDTO.setIdClasificacion(1);
            ppHormigaBL.add(ppOHormigaDTO);
            ppAlimentoInicio.remove(i);
        }
        pplarvas.remove(i);
    }

    }
    public void ppBuscando() throws Exception{
        List<HormigaDTO> ppHormigasActuales= ppHormigaBL.getAll();
        for(int i =0;i<ppHormigaBL.getMaxId();i++){
            if(ppAlimentoInicio.get(i).equals("Carnivoro")){
                HormigaDTO oHormigaDTO=new HormigaDTO();
                oHormigaDTO.setIdHormiga(ppHormigasActuales.get(i).getIdHormiga());
                oHormigaDTO.setCodigo(ppHormigasActuales.get(i).getCodigo());
                oHormigaDTO.setIdClasificacion(ppHormigasActuales.get(i).getIdClasificacion());
                oHormigaDTO.setComio(ppHormigasActuales.get(i).getComio());
                oHormigaDTO.setRecogio(1);
                ppHormigaBL.update(oHormigaDTO);
                ppAlimentoInicio.remove(i);
            }
            pplarvas.remove(i);
            HormigaDTO oHormigaDTO=new HormigaDTO();
                oHormigaDTO.setIdHormiga(ppHormigasActuales.get(i).getIdHormiga());
                oHormigaDTO.setCodigo(ppHormigasActuales.get(i).getCodigo());
                oHormigaDTO.setIdClasificacion(ppHormigasActuales.get(i).getIdClasificacion());
                oHormigaDTO.setComio(ppHormigasActuales.get(i).getComio());
                oHormigaDTO.setRecogio(0);
                ppHormigaBL.update(oHormigaDTO);
                ppAlimentoInicio.remove(i);
        }
    }
}
