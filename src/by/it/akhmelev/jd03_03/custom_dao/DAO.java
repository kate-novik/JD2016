package by.it.akhmelev.jd03_03.custom_dao;

import by.it.akhmelev.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {

    private static DAO dao; //синглтон для DAO

    public UserDAO user;    //DAO для пользователей
    public RoleDAO role;    //DAO для ролей

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //dao.ad = new AdDAO();
                    //...
                }
            }
        }
        return dao;
    }

    //общая команда для Create Update Delete
    protected int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            //тут нужно логгирование SQLException(e);
        }
        return result;
    }
}
