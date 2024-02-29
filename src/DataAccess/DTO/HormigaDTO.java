/*
|-------------------------------------|
| © 2024 EPN-FIS, All rights reserved |
| antony.cobos@epn.edu.ec             |
|-------------------------------------|
Autor: Antony Cobos && Christian Pisco
Fecha: 28 - 02 - 2024
Script: Clase Hormiga
*/

package DataAccess.DTO;

public class HormigaDTO {
    private Integer IdHormiga, IdAntBot, IdClasificacion;
    private String Codigo, Estado,FechaCrea,FechaModifica;
    
    public HormigaDTO(){}

    public HormigaDTO(Integer idHormiga, Integer idAntBot,String codigo, Integer idClasificacion, String Estado, String FechaCrea, String FechaModifica) {
        this.IdHormiga = idHormiga;
        this.Codigo=codigo;
        this.IdClasificacion = idClasificacion;
        this.IdAntBot = idAntBot;
        this.Estado=Estado;
        this.FechaCrea=FechaCrea;
        this.FechaModifica=FechaModifica;
    }

    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        this.IdHormiga = idHormiga;
    }

    public Integer getIdAntBot() {
        return IdAntBot;
    }

    public void setIdAntBot(Integer idAntBot) {
        IdAntBot = idAntBot;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public Integer getIdClasificacion() {
        return IdClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.IdClasificacion = idClasificacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCrea() {
        return FechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

}
