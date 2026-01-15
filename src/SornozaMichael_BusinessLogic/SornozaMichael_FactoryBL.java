//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package SornozaMichael_BusinessLogic;

import java.util.List;
import SornozaMichael_DataAccess.SornozaMichael_Interfaces.SornozaMichael_IDAO;
import Infrastructure.AppException;

public class SornozaMichael_FactoryBL<T> {
    private final SornozaMichael_IDAO<T> SornozaMichael_oDAO;

    @SuppressWarnings("unchecked")
    public SornozaMichael_FactoryBL(Class<? extends SornozaMichael_IDAO<T>> SornozaMichael_classDAO)
            throws AppException {
        try {

            this.SornozaMichael_oDAO = (SornozaMichael_IDAO<T>) SornozaMichael_classDAO.getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new AppException("Error al instanciar SornozaMichael_IDAO en el Factory", e, getClass(),
                    "FactoryBL(...)");
        }
    }

    public List<T> SornozaMichael_getAll() throws AppException {
        return SornozaMichael_oDAO.readAll();
    }

    public T SornozaMichael_getBy(Integer SornozaMichael_id) throws AppException {
        return SornozaMichael_oDAO.readBy(SornozaMichael_id);
    }

    public boolean SornozaMichael_add(T SornozaMichael_oT) throws AppException {
        return SornozaMichael_oDAO.create(SornozaMichael_oT);
    }

    public boolean SornozaMichael_upd(T SornozaMichael_oT) throws AppException {
        return SornozaMichael_oDAO.update(SornozaMichael_oT);
    }

    public boolean SornozaMichael_del(Integer SornozaMichael_id) throws AppException {
        return SornozaMichael_oDAO.delete(SornozaMichael_id);
    }

    public Integer SornozaMichael_getMax() throws AppException {
        return SornozaMichael_oDAO.getMaxReg();
    }
}
