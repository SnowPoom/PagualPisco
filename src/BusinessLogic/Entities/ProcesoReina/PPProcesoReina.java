package BusinessLogic.Entities.ProcesoReina;

import java.util.ArrayList;
import java.util.List;

import BusinessLogic.HormigaBL;
import BusinessLogic.PPLectorArchivo;
import BusinessLogic.Entities.Hormiga.Hormiga;
import DataAccess.DTO.HormigaDTO;

public class PPProcesoReina {

    private Hormiga ppReina = new Hormiga(4);
    private List<Hormiga> pplarvas;
    private HormigaBL ppHormigaBL = new HormigaBL();
    private List<String> ppAlimentoInicio;

    public PPProcesoReina() throws Exception {
        pplarvas = new ArrayList<>(40);
        for (int i = 0; i < 40; i++) {
            Hormiga ppHormiga = new Hormiga(3);
            ppHormiga.setCodigo(ppHormigaBL.getCodigoRandom());
            pplarvas.add(ppHormiga);
        }
        ppAlimentoInicio = PPLectorArchivo.ppReadFile();
    }

    public void ppAlimentarLarvas() throws Exception {
        for (int i = 0; i < 40; i++) {
            if (ppAlimentoInicio.get(0).equals("Carnivoro")) {
                HormigaDTO ppOHormigaDTO = new HormigaDTO();
                ppOHormigaDTO.setCodigo(ppHormigaBL.getCodigoRandom());
                ppOHormigaDTO.setComio(1);
                ppOHormigaDTO.setIdClasificacion(1);
                ppHormigaBL.add(ppOHormigaDTO);
                ppAlimentoInicio.remove(0);
            }
            pplarvas.remove(0);
            ppAlimentoInicio.remove(0);
        }

    }

    public void ppBuscando() throws Exception {
        List<HormigaDTO> ppHormigasActuales = ppHormigaBL.getAll();
        for (int i = 0; i < ppHormigaBL.getMaxId(); i++) {
            if (ppAlimentoInicio.get(0).equals("Carnivoro")) {
                HormigaDTO oHormigaDTO = new HormigaDTO();
                oHormigaDTO.setIdHormiga(ppHormigasActuales.get(0).getIdHormiga());
                oHormigaDTO.setCodigo(ppHormigasActuales.get(0).getCodigo());
                oHormigaDTO.setIdClasificacion(ppHormigasActuales.get(0).getIdClasificacion());
                oHormigaDTO.setComio(ppHormigasActuales.get(0).getComio());
                oHormigaDTO.setRecogio(1);
                ppHormigaBL.update(oHormigaDTO);
                ppAlimentoInicio.remove(0);
                ppHormigasActuales.remove(0);
            } else {
                ppHormigaBL.delete(ppHormigasActuales.get(0).getIdHormiga());
                ppAlimentoInicio.remove(0);
                ppHormigasActuales.remove(0);
            }
        }
    }
}
