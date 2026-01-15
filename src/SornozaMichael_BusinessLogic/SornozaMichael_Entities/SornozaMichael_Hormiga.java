package SornozaMichael_BusinessLogic.SornozaMichael_Entities;

import SornozaMichael_BusinessLogic.Interfaces.SornozaMichael_IHormiga;

public abstract class SornozaMichael_Hormiga implements SornozaMichael_IHormiga {
    protected Integer SornozaMichael_IdHormiga, SornozaMichael_IdHormigaTipo, SornozaMichael_IdSexo,
            SornozaMichael_IdEstado;
    protected String SornozaMichael_Nombre, SornozaMichael_Descripcion, SornozaMichael_Genoma,
            SornozaMichael_EstadoVida;
    protected String SornozaMichael_AlimentoAceptado;

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

    public Integer getSornozaMichael_IdSexo() {
        return SornozaMichael_IdSexo;
    }

    public void setSornozaMichael_IdSexo(Integer sornozaMichael_IdSexo) {
        SornozaMichael_IdSexo = sornozaMichael_IdSexo;
    }

    public Integer getSornozaMichael_IdEstado() {
        return SornozaMichael_IdEstado;
    }

    public void setSornozaMichael_IdEstado(Integer sornozaMichael_IdEstado) {
        SornozaMichael_IdEstado = sornozaMichael_IdEstado;
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

    public String getSornozaMichael_Genoma() {
        return SornozaMichael_Genoma;
    }

    public void setSornozaMichael_Genoma(String sornozaMichael_Genoma) {
        SornozaMichael_Genoma = sornozaMichael_Genoma;
    }

    public String getSornozaMichael_EstadoVida() {
        return SornozaMichael_EstadoVida;
    }

    public void setSornozaMichael_EstadoVida(String sornozaMichael_EstadoVida) {
        SornozaMichael_EstadoVida = sornozaMichael_EstadoVida;
    }

    public String getSornozaMichael_AlimentoAceptado() {
        return SornozaMichael_AlimentoAceptado;
    }

    public void setSornozaMichael_AlimentoAceptado(String sornozaMichael_AlimentoAceptado) {
        SornozaMichael_AlimentoAceptado = sornozaMichael_AlimentoAceptado;
    }

    public SornozaMichael_Hormiga() {
        this.SornozaMichael_EstadoVida = "VIVA";
    }

    @Override
    public boolean SornozaMichael_comer(SornozaMichael_Alimento SornozaMichael_a) {
        // Si el alimento es nulo, la hormiga muere automáticamente
        if (SornozaMichael_a == null) {
            this.SornozaMichael_EstadoVida = "MUERTA";
            this.SornozaMichael_IdEstado = 2;
            return false;
        }

        // Si hay alimento, verificamos si es el que le gusta
        if (SornozaMichael_a.getSornozaMichael_Nombre().equalsIgnoreCase(SornozaMichael_AlimentoAceptado)) {
            this.SornozaMichael_EstadoVida = "VIVA";
            this.SornozaMichael_IdEstado = 1;
            return true;
        }

        this.SornozaMichael_EstadoVida = "MUERTA";
        this.SornozaMichael_IdEstado = 2;
        return false;
    }
}
