package SornozaMichael_DataAccess.SornozaMichael_DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Infrastructure.AppException;
import SornozaMichael_DataAccess.DTOs.SornozaMichael_HormigaDTO;
import SornozaMichael_DataAccess.SornozaMichael_Helpers.SornozaMichael_DataHelperSQLiteDAO;

public class SornozaMichael_HormigaDAO extends SornozaMichael_DataHelperSQLiteDAO<SornozaMichael_HormigaDTO> {

    public SornozaMichael_HormigaDAO() throws AppException {

        super(SornozaMichael_HormigaDTO.class, "SornozaMichael_Hormiga", "SornozaMichael_IdHormiga");
    }

    public List<SornozaMichael_HormigaDTO> readAllvwHormiga() throws AppException {
        List<SornozaMichael_HormigaDTO> lst = new ArrayList<>();

        String query = " SELECT ID "
                + " ,Nombre "
                + " ,Descripcion "
                + " ,Tipo "
                + " ,Alimento "
                + " ,Estado "
                + " FROM vwHormiga";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                SornozaMichael_HormigaDTO dto = new SornozaMichael_HormigaDTO();

                dto.setSornozaMichael_IdHormiga(rs.getInt(1));
                dto.setSornozaMichael_Nombre(rs.getString(2));
                dto.setSornozaMichael_Descripcion(rs.getString(3));

                dto.setSornozaMichael_Estado(rs.getString(6));

                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new AppException("Error al leer la vista vwHormiga", e, getClass(), "readAllvwHormiga()");
        }
        return lst;
    }
}