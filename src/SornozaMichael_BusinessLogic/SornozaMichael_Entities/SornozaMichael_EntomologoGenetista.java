package SornozaMichael_BusinessLogic.SornozaMichael_Entities;

import java.util.Random;

public class SornozaMichael_EntomologoGenetista extends SornozaMichael_EntomologoBL {

    @Override
    public void SornozaMichael_prepararAlimento(SornozaMichael_Alimento SornozaMichael_a,
            SornozaMichael_Hormiga SornozaMichael_h) {

        String[] SornozaMichael_genomas = { "X", "XX", "XY" };
        String SornozaMichael_g = SornozaMichael_genomas[new Random().nextInt(3)];

        SornozaMichael_h.SornozaMichael_aplicarGenoma(SornozaMichael_g);

        System.out.println("Genetista preparando: [ " +
                SornozaMichael_a.getSornozaMichael_Nombre() + " + Gen: " +
                SornozaMichael_g + " ]");
    }

    @Override
    public SornozaMichael_Hormiga SornozaMichael_alimentarAnt(SornozaMichael_Hormiga SornozaMichael_h,
            SornozaMichael_Alimento SornozaMichael_a) {

        SornozaMichael_prepararAlimento(SornozaMichael_a, SornozaMichael_h);

        SornozaMichael_h.SornozaMichael_comer(SornozaMichael_a);

        return SornozaMichael_h;
    }
}