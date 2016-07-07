package by.it.kushel.jd03_02;

import by.it.akhmelev.jd03_02.*;
import by.it.akhmelev.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex_01__CreateTable {


    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {

            statement.executeUpdate("DROP TABLE IF EXISTS kushel.test_Table ");


            String createTableSQL =
                    "CREATE TABLE kushel.test_Table("
                            + "USER_ID INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary key!!!', "
                            + "USERNAME VARCHAR(20) NOT NULL, "
                            + "PRIMARY KEY (USER_ID) "
                            + ")";
            statement.executeUpdate(createTableSQL);


            statement.executeUpdate(
                    "INSERT INTO kushel.test_Table (USERNAME) VALUES ('Test+Ann');"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
