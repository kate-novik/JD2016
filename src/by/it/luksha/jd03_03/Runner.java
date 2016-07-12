package by.it.luksha.jd03_03;


import by.it.luksha.jd03_03.beans.User;
import by.it.luksha.jd03_03.connector.ConnectorDB;
import by.it.luksha.jd03_03.dao.DAO;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        try {
            Connection cn = ConnectorDB.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users;");
            while (rs.next()) {
                System.out.printf("%s ", rs.getString("Login"));
            }
            DatabaseMetaData databaseMetaData = cn.getMetaData();
            System.out.printf("\n%s\n", databaseMetaData.getDriverName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DAO dao = DAO.getDAO();
        User user = new User(0, "Batman", "123qwe", "iambat@gmail.com", 2);
        //add
        dao.getUserDAO().create(user);
        System.out.printf("%s", user);
    }
}
