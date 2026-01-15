package SornozaMichael_BusinessLogic.Interfaces;

import java.util.List;

import Infrastructure.AppException;
import SornozaMichael_BusinessLogic.SornozaMichael_Entities.SornozaMichael_Alimento;
import SornozaMichael_BusinessLogic.SornozaMichael_Entities.SornozaMichael_Hormiga;

public interface SornozaMichael_IEntomologo {
    List<SornozaMichael_Hormiga> SornozaMichael_etlAntNest() throws AppException;

    List<SornozaMichael_Alimento> SornozaMichael_etlAntFood() throws AppException;

    SornozaMichael_Hormiga SornozaMichael_alimentarAnt(SornozaMichael_Hormiga SornozaMichael_h,
            SornozaMichael_Alimento SornozaMichael_a);

    void SornozaMichael_prepararAlimento(SornozaMichael_Alimento SornozaMichael_a,
            SornozaMichael_Hormiga SornozaMichael_h);
}
