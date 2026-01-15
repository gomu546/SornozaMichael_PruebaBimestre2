package SornozaMichael_BusinessLogic.SornozaMichael_Entities;

public class SornozaMichael_HObrera extends SornozaMichael_Hormiga {
    private String SornozaMichael_tipoManotijera;

    public SornozaMichael_HObrera() {
        this.SornozaMichael_IdHormigaTipo = 2;
        this.SornozaMichael_AlimentoAceptado = "Herbivoro";
    }

    @Override
    public void SornozaMichael_aplicarGenoma(String SornozaMichael_g) {
        this.SornozaMichael_Genoma = SornozaMichael_g;
        if ("XY".equals(SornozaMichael_g)) {
            this.SornozaMichael_tipoManotijera = "Acero";
            this.SornozaMichael_IdSexo = 1;
            SornozaMichael_superCortadora();
        }
    }

    public void SornozaMichael_superCortadora() {
        this.SornozaMichael_Descripcion = "Habilidad: Corte con tijeras de " + SornozaMichael_tipoManotijera;
    }
}
