package by.it.luksha.jd03_03;


import by.it.luksha.jd03_03.connector.ConnectorDB;

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
            System.out.printf("\n%s", databaseMetaData.getDriverName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
