package SornozaMichael_DataAccess.DTOs;

public class SornozaMichael_HormigaDTO {

    private Integer SornozaMichael_IdHormiga;
    private Integer SornozaMichael_IdHormigaTipo;
    private Integer SornozaMichael_AlimentoTipo;
    private String SornozaMichael_Nombre;
    private String SornozaMichael_Descripcion;
    private String SornozaMichael_Estado;
    private String SornozaMichael_FechaCreacion;
    private String SornozaMichael_FechaModifica;

    public SornozaMichael_HormigaDTO(Integer sornozaMichael_IdHormiga, Integer sornozaMichael_IdHormigaTipo,
            Integer sornozaMichael_AlimentoTipo, String sornozaMichael_Nombre, String sornozaMichael_Descripcion,
            String sornozaMichael_Estado, String sornozaMichael_FechaCreacion, String sornozaMichael_FechaModifica) {
        SornozaMichael_IdHormiga = sornozaMichael_IdHormiga;
        SornozaMichael_IdHormigaTipo = sornozaMichael_IdHormigaTipo;
        SornozaMichael_AlimentoTipo = sornozaMichael_AlimentoTipo;
        SornozaMichael_Nombre = sornozaMichael_Nombre;
        SornozaMichael_Descripcion = sornozaMichael_Descripcion;
        SornozaMichael_Estado = sornozaMichael_Estado;
        SornozaMichael_FechaCreacion = sornozaMichael_FechaCreacion;
        SornozaMichael_FechaModifica = sornozaMichael_FechaModifica;
    }

    public SornozaMichael_HormigaDTO() {
    }

    public Integer getSornozaMichael_IdHormiga() {
        return SornozaMichael_IdHormiga;
    }

    public void setSornozaMichael_IdHormiga(Integer sornozaMichael_IdHormiga) {
        SornozaMichael_IdHormiga = sornozaMichael_IdHormiga;
    }

    public Integer getSornozaMichael_IdHormigaTipo() {
        return SornozaMichael_IdHormigaTipo;
    }

    public void setSornozaMichael_IdHormigaTipo(Integer sornozaMichael_IdHormigaTipo) {
        SornozaMichael_IdHormigaTipo = sornozaMichael_IdHormigaTipo;
    }

    public Integer getSornozaMichael_AlimentoTipo() {
        return SornozaMichael_AlimentoTipo;
    }

    public void setSornozaMichael_AlimentoTipo(Integer sornozaMichael_AlimentoTipo) {
        SornozaMichael_AlimentoTipo = sornozaMichael_AlimentoTipo;
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
                + "\n IdHormiga     : " + getSornozaMichael_IdHormiga()
                + "\n IdHormigaTipo : " + getSornozaMichael_IdHormigaTipo()
                + "\n IdAlimentoTipo: " + getSornozaMichael_AlimentoTipo()
                + "\n Nombre        : " + getSornozaMichael_Nombre()
                + "\n Descripcion   : " + getSornozaMichael_Descripcion()
                + "\n Estado        : " + getSornozaMichael_Estado()
                + "\n FechaCreacion : " + getSornozaMichael_FechaCreacion()
                + "\n FechaModifica : " + getSornozaMichael_FechaModifica();
    }

}