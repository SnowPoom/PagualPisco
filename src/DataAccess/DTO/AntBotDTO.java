package DataAccess.DTO;


public class AntBotDTO {
    private Integer IdAntBot;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    public AntBotDTO(){}
    public AntBotDTO(Integer idAntBot,
    String Estado,
    String FechaCrea,
    String FechaModifica){
        this.IdAntBot=idAntBot;
        this.Estado=Estado;
        this.FechaCrea=FechaCrea;
        this.FechaModifica=FechaModifica;
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
    public Integer getIdAntBot() {
        return IdAntBot;
    }

    public void setIdAntBot(Integer idAntBot) {
        this.IdAntBot = idAntBot;
    }

    
}
