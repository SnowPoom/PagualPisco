package DataAccess.DTO;

public class ClasificacionDTO {
    Integer IdClasificacion;
    String Nombre;
    String Estado;
    String FechaCrea;
    String FechaModifica;
    
    public ClasificacionDTO() {}

    public ClasificacionDTO(Integer idClasificacion, String nombre, String estado, String fechaCrea,
            String fechaModifica) {
        IdClasificacion = idClasificacion;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }

    public Integer getIdClasificacion() {
        return IdClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        IdClasificacion = idClasificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
