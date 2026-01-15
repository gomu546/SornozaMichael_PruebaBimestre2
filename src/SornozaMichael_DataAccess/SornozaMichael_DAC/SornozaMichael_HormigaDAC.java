package SornozaMichael_DataAccess.SornozaMichael_DAC;

import SornozaMichael_BusinessLogic.SornozaMichael_Entities.SornozaMichael_Hormiga;
import SornozaMichael_DataAccess.SornozaMichael_Helpers.SornozaMichael_DataHelperSQLiteDAO;
import Infrastructure.AppException;

public class SornozaMichael_HormigaDAC extends SornozaMichael_DataHelperSQLiteDAO<SornozaMichael_Hormiga> {

    public SornozaMichael_HormigaDAC() throws AppException {
        super(SornozaMichael_Hormiga.class, "SornozaMichael_Hormiga", "SornozaMichael_IdHormiga");
    }

}