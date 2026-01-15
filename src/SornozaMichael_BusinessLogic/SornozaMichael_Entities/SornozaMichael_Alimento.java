package SornozaMichael_BusinessLogic.SornozaMichael_Entities;

public abstract class SornozaMichael_Alimento {
    protected Integer SornozaMichael_IdAlimento;
    protected Integer SornozaMichael_IdTipoAlimento;
    protected String SornozaMichael_Nombre;
    protected String SornozaMichael_Descripcion;
    protected String SornozaMichael_FechaCreacion;
    protected String SornozaMichael_FechaModifica;

    public SornozaMichael_Alimento() {
    }

    public Integer getSornozaMichael_IdAlimento() {
        return SornozaMichael_IdAlimento;
    }

    public void setSornozaMichael_IdAlimento(Integer sornozaMichael_IdAlimento) {
        SornozaMichael_IdAlimento = sornozaMichael_IdAlimento;
    }

    public Integer getSornozaMichael_IdTipoAlimento() {
        return SornozaMichael_IdTipoAlimento;
    }

    public void setSornozaMichael_IdTipoAlimento(Integer sornozaMichael_IdTipoAlimento) {
        SornozaMichael_IdTipoAlimento = sornozaMichael_IdTipoAlimento;
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
}
