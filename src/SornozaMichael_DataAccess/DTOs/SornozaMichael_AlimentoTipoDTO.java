package SornozaMichael_DataAccess.DTOs;

public class SornozaMichael_AlimentoTipoDTO {
    private Integer SornozaMichael_IdAlimentoTipo;
    private String SornozaMichael_Nombre;
    private String SornozaMichael_Descripcion;
    private String SornozaMichael_Estado;
    private String SornozaMichael_FechaCreacion;
    private String SornozaMichael_FechaModifica;

    public SornozaMichael_AlimentoTipoDTO() {
    }

    public SornozaMichael_AlimentoTipoDTO(String SornozaMichael_nombre, String SornozaMichael_descripcion) {
        SornozaMichael_IdAlimentoTipo = 0;
        SornozaMichael_Nombre = SornozaMichael_nombre;
        SornozaMichael_Descripcion = SornozaMichael_descripcion;

    }

    public SornozaMichael_AlimentoTipoDTO(Integer sornozaMichael_IdAlimentoTipo, String sornozaMichael_Nombre,
            String sornozaMichael_Descripcion, String sornozaMichael_Estado, String sornozaMichael_FechaCreacion,
            String sornozaMichael_FechaModifica) {
        SornozaMichael_IdAlimentoTipo = sornozaMichael_IdAlimentoTipo;
        SornozaMichael_Nombre = sornozaMichael_Nombre;
        SornozaMichael_Descripcion = sornozaMichael_Descripcion;
        SornozaMichael_Estado = sornozaMichael_Estado;
        SornozaMichael_FechaCreacion = sornozaMichael_FechaCreacion;
        SornozaMichael_FechaModifica = sornozaMichael_FechaModifica;
    }

    public Integer getSornozaMichael_IdAlimentoTipo() {
        return SornozaMichael_IdAlimentoTipo;
    }

    public void setSornozaMichael_IdAlimentoTipo(Integer sornozaMichael_IdAlimentoTipo) {
        SornozaMichael_IdAlimentoTipo = sornozaMichael_IdAlimentoTipo;
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
                + "\n IdAlimentoTipo: " + getSornozaMichael_IdAlimentoTipo()
                + "\n Nombre        : " + getSornozaMichael_Nombre()
                + "\n Descripcion   : " + getSornozaMichael_Descripcion()
                + "\n Estado        : " + getSornozaMichael_Estado()
                + "\n FechaCreacion : " + getSornozaMichael_FechaCreacion()
                + "\n FechaModifica : " + getSornozaMichael_FechaModifica()
                + "\n --------------------------- ";
    }

}
