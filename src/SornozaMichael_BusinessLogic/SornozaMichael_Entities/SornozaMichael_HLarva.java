package SornozaMichael_BusinessLogic.SornozaMichael_Entities;

public class SornozaMichael_HLarva extends SornozaMichael_Hormiga {
    private int SornozaMichael_nroPies;

    public SornozaMichael_HLarva() {
        this.SornozaMichael_IdHormigaTipo = 1;
        this.SornozaMichael_AlimentoAceptado = "Nectarvoro";
    }

    @Override
    public void SornozaMichael_aplicarGenoma(String SornozaMichael_g) {
        this.SornozaMichael_Genoma = SornozaMichael_g;
        if ("XX".equals(SornozaMichael_g)) {
            this.SornozaMichael_nroPies = 6;
            this.SornozaMichael_IdSexo = 2;
            SornozaMichael_superSaltar();
        }
    }

    public void SornozaMichael_superSaltar() {
        this.SornozaMichael_Descripcion = "Habilidad: Salto con " + SornozaMichael_nroPies + " pies.";
    }
}
