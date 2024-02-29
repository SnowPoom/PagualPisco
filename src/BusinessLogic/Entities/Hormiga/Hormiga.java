/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| antony.cobos@epn.edu.ec             |
|-------------------------------------|
Autor: Antony Cobos && Christian Pisco
Fecha: 28 - 02 - 2024
Script: Clase Hormiga
*/

package BusinessLogic.Entities.Hormiga;

import BusinessLogic.HormigaBL;
import BusinessLogic.Entities.AntBot.AntBot;
import DataAccess.DTO.HormigaDTO;
import Framework.AntException;

public class Hormiga {
    private AntBot antBot = null;
    private Integer idClasificacion;
    private String codigo;
    private HormigaBL hormigaBL = new HormigaBL();

    public Hormiga() throws Exception {
        HormigaDTO hormigaDTO = new HormigaDTO();
        
        try {
            idClasificacion = hormigaBL.getIdClasificacionRandom();
            codigo = hormigaBL.getCodigoRandom();

            if (hormigaBL.tieneAntBot(idClasificacion)) {
                antBot = new AntBot(idClasificacion, hormigaDTO);
                hormigaDTO.setIdAntBot(idClasificacion);
                hormigaDTO.setIdClasificacion(idClasificacion);
                hormigaDTO.setCodigo(codigo);
                hormigaBL.add(hormigaDTO);
            } else{
                hormigaDTO.setIdAntBot(-1);
                hormigaDTO.setIdClasificacion(idClasificacion);
                hormigaDTO.setCodigo(codigo);
                hormigaBL.add(hormigaDTO);
            }

        } catch (Exception e) {
            throw new AntException(e.getMessage(), getClass().getName(), "Hormiga()");
        }
    }

    public AntBot getAntBot() throws Exception {
        return antBot;
    }

    public void setAntBot(AntBot antBot) throws Exception {
        this.antBot = antBot;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
