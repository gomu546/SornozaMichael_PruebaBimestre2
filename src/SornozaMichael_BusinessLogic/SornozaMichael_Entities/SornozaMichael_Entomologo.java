package SornozaMichael_BusinessLogic.SornozaMichael_Entities;

public class SornozaMichael_Entomologo extends SornozaMichael_EntomologoBL {

    @Override
    public void SornozaMichael_prepararAlimento(SornozaMichael_Alimento SornozaMichael_a,
            SornozaMichael_Hormiga SornozaMichael_h) {

        System.out.println("Entomólogo Normal sirviendo: [ " + SornozaMichael_a.getSornozaMichael_Nombre() + " ]");
    }

    @Override
    public SornozaMichael_Hormiga SornozaMichael_alimentarAnt(SornozaMichael_Hormiga SornozaMichael_h,
            SornozaMichael_Alimento SornozaMichael_a) {

        SornozaMichael_prepararAlimento(SornozaMichael_a, SornozaMichael_h);

        SornozaMichael_h.SornozaMichael_comer(SornozaMichael_a);

        return SornozaMichael_h;
    }
}
