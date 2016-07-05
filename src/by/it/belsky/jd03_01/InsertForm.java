package by.it.belsky.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by misha on 05.07.2016.
 */
public class InsertForm {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (java.sql.Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {

            statement.executeUpdate(
                    "insert into form (ID, YearOfIssue, CarModel, Engine,\n" +
                            "Transmisson, Body, Suspension, Maintenance, FK_Users, ElectricsSalonexhaustSystemOthers)\n" +
                            " values (null, 1999, 'wwgolf', 'isOK', 'isOK', 'isOK',\n" +
                            " 'the  lever rear wheel is broken', 'replace engine oil', 1, ' left turn signal is not working');"
            );
            statement.executeUpdate(
                    "insert into form (ID, YearOfIssue, CarModel, Engine,\n" +
                            "Transmisson, Body, Suspension, Maintenance, FK_Users, ElectricsSalonexhaustSystemOthers)\n" +
                            " values (null, 2010, 'toyotacorolla', 'oil leak', 'isOK', 'damaged right wing',\n" +
                            " 'isOK', 'isOK', 1, 'torn back seat');");
            statement.executeUpdate(
                    "insert into form (ID, YearOfIssue, CarModel, Engine,\n" +
                            "Transmisson, Body, Suspension, Maintenance, FK_Users, ElectricsSalonexhaustSystemOthers)\n" +
                            " values (null, 2013, 'ladasamara', 'heavy vibration', 'crackling in gear box', 'rust on the front door',\n" +
                            " 'isOk', 'isOk', 1, 'radio does not work');");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
