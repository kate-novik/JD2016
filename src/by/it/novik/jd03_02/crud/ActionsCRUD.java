package by.it.novik.jd03_02.crud;

import java.sql.SQLException;

/**
 * Created by Kate Novik.
 */
public interface ActionsCRUD<T,ID> {
    /**
     * Выполнение операций с БД
     */
    T create (T object) throws SQLException;
    T read (ID id) throws SQLException;
    T update (T object) throws SQLException;
    boolean delete (T object) throws SQLException;
}
