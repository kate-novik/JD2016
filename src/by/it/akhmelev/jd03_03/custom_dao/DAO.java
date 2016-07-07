package by.it.akhmelev.jd03_03.custom_dao;

import by.it.akhmelev.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

