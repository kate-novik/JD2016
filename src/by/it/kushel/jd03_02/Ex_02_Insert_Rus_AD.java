package by.it.kushel.jd03_02;

import by.it.akhmelev.jd03_02.*;
import by.it.akhmelev.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.Statement;

public class Ex_02_Insert_Rus_AD {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement();) {

            statement.executeUpdate(
                    "INSERT INTO kushel.books (ID, Name, Author, Genre, UserID) "+
                            "VALUES ('6', 'Compass', 'Socol', 'educational', '5');"
            );
            statement.executeUpdate(
                    "INSERT INTO kushel.books (ID, Name, Author, Genre, UserID) "+
                            "VALUES ('7', 'Algorithm', 'Beily', 'educational', '2');"
            );

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
