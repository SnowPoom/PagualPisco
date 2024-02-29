package DataAccess.DTO;

public class PPHormigaClasificacionDTO {
    private Integer IdHormiga;
    private String Codigo;
    private String Clasificaion;
    
    public PPHormigaClasificacionDTO() {}
    
    public PPHormigaClasificacionDTO(Integer idHormiga, String codigo, String clasificaion) {
        IdHormiga = idHormiga;
        Codigo = codigo;
        Clasificaion = clasificaion;
    }

    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer idHormiga) {
        IdHormiga = idHormiga;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getClasificaion() {
        return Clasificaion;
    }

    public void setClasificaion(String clasificaion) {
        Clasificaion = clasificaion;
    }

}
