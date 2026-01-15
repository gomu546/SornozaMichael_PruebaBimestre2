//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package SornozaMichael_DataAccess.SornozaMichael_Helpers;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Infrastructure.AppConfig;
import Infrastructure.AppException;
import SornozaMichael_DataAccess.SornozaMichael_Interfaces.SornozaMichael_IDAO;

public class SornozaMichael_DataHelperSQLiteDAO<T> implements SornozaMichael_IDAO<T> {
    protected final Class<T> DTOClass;
    protected final String tableName;
    protected final String tablePK;

    // Nombres de columnas técnicas con prefijo para que coincidan con tu SQL
    private final String COL_ESTADO = "SornozaMichael_Estado";
    private final String COL_FECHA_CREA = "SornozaMichael_FechaCreacion";
    private final String COL_FECHA_MOD = "SornozaMichael_FechaModifica";

    private static final String DBPath = AppConfig.DATABASE;
    private static Connection conn = null;

    protected static synchronized Connection openConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                throw new SQLException("No se encontró el driver de SQLite en el classpath", e);
            }
            conn = DriverManager.getConnection(DBPath);
        }
        return conn;
    }

    protected static void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    protected String getDataTimeNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public SornozaMichael_DataHelperSQLiteDAO(Class<T> dtoClass, String tableName, String tablePK) throws AppException {
        try {
            openConnection();
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "SornozaMichael_DataHelperSQLiteDAO");
        }
        this.DTOClass = dtoClass;
        this.tableName = tableName;
        this.tablePK = tablePK;
    }

    @Override
    public boolean create(T entity) throws AppException {
        Field[] fields = DTOClass.getDeclaredFields();
        StringBuilder columns = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();

        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            if (!name.equalsIgnoreCase(tablePK)
                    && !name.equalsIgnoreCase(COL_ESTADO)
                    && !name.equalsIgnoreCase(COL_FECHA_CREA)
                    && !name.equalsIgnoreCase(COL_FECHA_MOD)) {
                columns.append(name).append(",");
                placeholders.append("?,");
            }
        }

        String cols = columns.substring(0, columns.length() - 1);
        String vals = placeholders.substring(0, placeholders.length() - 1);
        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, cols, vals);

        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            int index = 1;
            for (Field field : fields) {
                String name = field.getName();
                if (!name.equalsIgnoreCase(tablePK)
                        && !name.equalsIgnoreCase(COL_ESTADO)
                        && !name.equalsIgnoreCase(COL_FECHA_CREA)
                        && !name.equalsIgnoreCase(COL_FECHA_MOD))
                    stmt.setObject(index++, field.get(entity));
            }
            return (stmt.executeUpdate() > 0);
        } catch (SQLException | IllegalAccessException e) {
            throw new AppException(null, e, getClass(), "create");
        }
    }

    @Override
    public boolean update(T entity) throws AppException {
        try {
            Field[] fields = DTOClass.getDeclaredFields();
            StringBuilder updates = new StringBuilder();
            Object pkValue = null;

            for (Field field : fields) {
                String name = field.getName();
                if (!name.equalsIgnoreCase(tablePK) && !name.equalsIgnoreCase(COL_FECHA_CREA)
                        && !name.equalsIgnoreCase(COL_ESTADO)) {
                    updates.append(name).append(" = ?, ");
                } else if (name.equalsIgnoreCase(tablePK)) {
                    field.setAccessible(true);
                    pkValue = field.get(entity);
                }
            }

            updates.append(COL_FECHA_MOD).append(" = ?");
            String sql = String.format("UPDATE %s SET %s WHERE %s = ?", tableName, updates.toString(), tablePK);

            try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
                int index = 1;
                for (Field field : fields) {
                    String name = field.getName();
                    if (!name.equalsIgnoreCase(tablePK) && !name.equalsIgnoreCase(COL_FECHA_CREA)
                            && !name.equalsIgnoreCase(COL_ESTADO)) {
                        field.setAccessible(true);
                        stmt.setObject(index++, field.get(entity));
                    }
                }
                stmt.setString(index++, getDataTimeNow());
                stmt.setObject(index, pkValue);
                return stmt.executeUpdate() > 0;
            }
        } catch (SQLException | IllegalAccessException e) {
            throw new AppException(null, e, getClass(), "update");
        }
    }

    @Override
    public boolean delete(Integer id) throws AppException {
        String sql = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ?", tableName, COL_ESTADO, COL_FECHA_MOD,
                tablePK);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, "X");
            stmt.setString(2, getDataTimeNow());
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "delete");
        }
    }

    @Override
    public T readBy(Integer id) throws AppException {
        String sql = String.format("SELECT * FROM %s WHERE %s = ? AND %s = 'A'", tableName, tablePK, COL_ESTADO);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? mapResultSetToEntity(rs) : null;
            }
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "readBy");
        }
    }

    @Override
    public List<T> readAll() throws AppException {
        List<T> list = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s WHERE %s = 'A'", tableName, COL_ESTADO);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "readAll");
        }
        return list;
    }

    @Override
    public Integer getMaxReg() throws AppException {
        String sql = String.format("SELECT COUNT(*) FROM %s WHERE %s = 'A'", tableName, COL_ESTADO);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getMaxReg");
        }
    }

    protected T mapResultSetToEntity(ResultSet rs) throws AppException {
        try {
            T instance = DTOClass.getDeclaredConstructor().newInstance();
            ResultSetMetaData meta = rs.getMetaData();

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                String col = meta.getColumnLabel(i);
                Object val = rs.getObject(i);

                Field field = DTOClass.getDeclaredField(col);
                field.setAccessible(true);
                field.set(instance, val);
            }
            return instance;
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException
                | IllegalAccessException | NoSuchFieldException e) {
            throw new AppException(null, e, getClass(), "mapResultSetToEntity");
        }
    }
}