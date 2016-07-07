package by.it.kushel.jd03_02;

import by.it.akhmelev.jd03_02.*;
import by.it.akhmelev.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.Statement;

public class Ex_01__Rus_Users {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();) {

            statement.executeUpdate(
                    "insert into kushel.users(Login,Password,Email)"+
                            " values('nik2','abc5','nik@tut.by');"

            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
