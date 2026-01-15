package SornozaMichael_DataAccess.DTOs;

public class SornozaMichael_HormigaTipoDTO {
    private Integer SornozaMichael_IdHormigaTipo;
    private String SornozaMichael_Nombre;
    private String SornozaMichael_Descripcion;
    private String SornozaMichael_Estado;
    private String SornozaMichael_FechaCreacion;
    private String SornozaMichael_FechaModifica;

    public SornozaMichael_HormigaTipoDTO(Integer sornozaMichael_IdHormigaTipo, String sornozaMichael_Nombre,
            String sornozaMichael_Descripcion, String sornozaMichael_Estado, String sornozaMichael_FechaCreacion,
            String sornozaMichael_FechaModifica) {
        SornozaMichael_IdHormigaTipo = sornozaMichael_IdHormigaTipo;
        SornozaMichael_Nombre = sornozaMichael_Nombre;
        SornozaMichael_Descripcion = sornozaMichael_Descripcion;
        SornozaMichael_Estado = sornozaMichael_Estado;
        SornozaMichael_FechaCreacion = sornozaMichael_FechaCreacion;
        SornozaMichael_FechaModifica = sornozaMichael_FechaModifica;
    }

    public Integer getSornozaMichael_IdHormigaTipo() {
        return SornozaMichael_IdHormigaTipo;
    }

    public void setSornozaMichael_IdHormigaTipo(Integer sornozaMichael_IdHormigaTipo) {
        SornozaMichael_IdHormigaTipo = sornozaMichael_IdHormigaTipo;
    }

    public String getSornozaMichael_Nombre() {
        return SornozaMichael_Nombre;
    }

    public void setSornozaMichael_Nombre(String sornozaMichael_Nombre) {
        SornozaMichael_Nombre = sornozaMichael_Nombre;
    }

    public String getSornozaMichael_Descripcion() {
        return SornozaMichael_Descripcion;
    }

    public void setSornozaMichael_Descripcion(String sornozaMichael_Descripcion) {
        SornozaMichael_Descripcion = sornozaMichael_Descripcion;
    }

    public String getSornozaMichael_Estado() {
        return SornozaMichael_Estado;
    }

    public void setSornozaMichael_Estado(String sornozaMichael_Estado) {
        SornozaMichael_Estado = sornozaMichael_Estado;
    }

    public String getSornozaMichael_FechaCreacion() {
        return SornozaMichael_FechaCreacion;
    }

    public void setSornozaMichael_FechaCreacion(String sornozaMichael_FechaCreacion) {
        SornozaMichael_FechaCreacion = sornozaMichael_FechaCreacion;
    }

    public String getSornozaMichael_FechaModifica() {
        return SornozaMichael_FechaModifica;
    }

    public void setSornozaMichael_FechaModifica(String sornozaMichael_FechaModifica) {
        SornozaMichael_FechaModifica = sornozaMichael_FechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n  IdHormigaTipo        : " + getSornozaMichael_IdHormigaTipo()
                + "\n  Nombre          : " + getSornozaMichael_Nombre()
                + "\n  Descripcion     : " + getSornozaMichael_Descripcion()
                + "\n  Estado          : " + getSornozaMichael_Estado()
                + "\n  FechaCreacion   : " + getSornozaMichael_FechaCreacion()
                + "\n  FechaModifica   : " + getSornozaMichael_FechaModifica()
                + "\n-----------------------------------";
    }
}
