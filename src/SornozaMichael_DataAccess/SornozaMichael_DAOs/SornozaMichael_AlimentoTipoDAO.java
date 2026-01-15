package SornozaMichael_DataAccess.SornozaMichael_DAOs;

import Infrastructure.AppException;
import SornozaMichael_DataAccess.DTOs.SornozaMichael_AlimentoTipoDTO;
import SornozaMichael_DataAccess.SornozaMichael_Helpers.SornozaMichael_DataHelperSQLiteDAO;

public class SornozaMichael_AlimentoTipoDAO extends SornozaMichael_DataHelperSQLiteDAO<SornozaMichael_AlimentoTipoDTO> {
    public SornozaMichael_AlimentoTipoDAO() throws AppException {
        super(SornozaMichael_AlimentoTipoDTO.class, "AlimentoTipo", "IdAlimentoTipo");
    }
}
