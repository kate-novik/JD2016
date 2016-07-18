package by.it.sereda.project.java.dao;


import by.it.sereda.project.java.beans.Rent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RentDAO extends AbstractDAO implements InterfaceDAO<Rent> {
    @Override
    public Rent read(int id) {
        List<Rent> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Rent rent) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "insert INTO rent(RoomCount,Price,Area,Floor,Floors,Address,Description,FK_Users)" +
                        "\n values('%d', '%.3f', '%.3f', '%d', '%d', '%s', '%s' ,'%d');",
                rent.getRoomCount(),
                rent.getPrice(),
                rent.getArea(),
                rent.getFloor(),
                rent.getFloors(),
                rent.getAddress(),
                rent.getDescription(),
                rent.getFK_Users()
        );
        rent.setID(executeUpdate(sql));
        return (rent.getID() > 0);
    }

    @Override
    public boolean update(Rent rent) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `rent` SET " +
                        "`RoomCount`=%d " +
                        ",`Price`='%.3f'" +
                        ",`Area`='%.3f'" +
                        ",`Floor`=%d" +
                        ",`Floors`=%d" +
                        ",`Address`='%s'" +
                        ",`Description`='%s'" +
                        ",`FK_Users`=%d " +
                        " WHERE `rent`.`ID` = %d",
                rent.getRoomCount(),
                rent.getPrice(),
                rent.getArea(),
                rent.getFloor(),
                rent.getFloors(),
                rent.getAddress(),
                rent.getDescription(),
                rent.getFK_Users(),
                rent.getID()
        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Rent rent) {
        String sql = String.format(
                "DELETE FROM `rent` WHERE `rent`.`ID`=%d;", rent.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Rent> getAll(String WHERE) {
        List<Rent> rents = new ArrayList<>();
        String sql = "SELECT * FROM rent " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Rent rent = new Rent();
                rent.setID(rs.getInt("ID"));
                rent.setAddress(rs.getString("Address"));
                rent.setArea(rs.getDouble("Area"));
                rent.setDescription(rs.getString("Description"));
                rent.setFK_Users(rs.getInt("FK_Users"));
                rent.setFloor(rs.getInt("Floor"));
                rent.setFloors(rs.getInt("Floors"));
                rent.setPrice(rs.getDouble("Price"));
                rent.setRoomCount(rs.getInt("RoomCount"));
                rents.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rents;
    }
}
