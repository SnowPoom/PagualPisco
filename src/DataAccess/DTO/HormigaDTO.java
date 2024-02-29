package DataAccess.DTO;

public class HormigaDTO {
    private Integer IdHormiga, 
                    IdAntBot, 
                    IdClasificacion;
    private String  Codigo, 
                    Estado,
                    FechaCrea,
                    FechaModifica;
    private Integer Comio, 
                    Recogio;

    public HormigaDTO(){}

    public HormigaDTO(Integer IdHormiga, 
                      Integer IdAntBot,
                      String Codigo, 
                      Integer IdClasificacion, 
                      String Estado,
                      String FechaCrea,
                      String FechaModifica,
                      Integer Comio,
                      Integer Recogio) {
        this.IdHormiga = IdHormiga;
        this.Codigo=Codigo;
        this.IdClasificacion = IdClasificacion;
        this.IdAntBot = IdAntBot;
        this.Comio = Comio;
        this.Recogio = Recogio;
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

    public Integer getComio() {
        return Comio;
    }

    public void setComio(Integer comio) {
        Comio = comio;
    }

    public Integer getRecogio() {
        return Recogio;
    }

    public void setRecogio(Integer recogio) {
        Recogio = recogio;
    }
}
