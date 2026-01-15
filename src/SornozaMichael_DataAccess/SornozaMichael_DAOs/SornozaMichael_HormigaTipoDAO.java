package SornozaMichael_DataAccess.SornozaMichael_DAOs;

import Infrastructure.AppException;
import SornozaMichael_DataAccess.DTOs.SornozaMichael_HormigaTipoDTO;
import SornozaMichael_DataAccess.SornozaMichael_Helpers.SornozaMichael_DataHelperSQLiteDAO;

public class SornozaMichael_HormigaTipoDAO extends SornozaMichael_DataHelperSQLiteDAO<SornozaMichael_HormigaTipoDTO> {

    public SornozaMichael_HormigaTipoDAO() throws AppException {
        super(SornozaMichael_HormigaTipoDTO.class, "SornozaMichael_HormigaTipo", "SornozaMichael_IdHormigaTipo");
    }
}
