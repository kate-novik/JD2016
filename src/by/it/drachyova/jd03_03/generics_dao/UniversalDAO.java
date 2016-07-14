package by.it.drachyova.jd03_03.generics_dao;

import by.it.drachyova.jd03_03.connection.ConnectionCreator;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversalDAO<TypeBean> {

    private TypeBean bean;
    private String table;
    Field[] fields;

    public UniversalDAO(TypeBean bean, String sqlTableName) {
        this.bean = bean;
        this.table = sqlTableName;
        this.fields = bean.getClass().getDeclaredFields();
    }

    public List<TypeBean> getAll(String WHERE) throws SQLException {
        List<TypeBean> beans = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            //            for (int i = 0; i < fields.length; i++) {
            //                System.out.println(fields[i]+":"+fields[i].getType());}
            while (resultSet.next()) {
                //создаем копию бина, в который будем складывать запись из Recordset
                TypeBean newBean = newBean();
                for (int i = 1; i < fields.length + 1; i++) {
                    //перебирая поля бина по очереди извлекаем значения в соответствии с их типом
                    Field field = fields[i - 1];
                    field.setAccessible(true);
                    String strType = field.getType().toString();
                    try {
                        if (field.getType() == Boolean.class || strType.equals("boolean"))
                            field.set(newBean, resultSet.getBoolean(i));
                        if (field.getType() == Byte.class || strType.equals("byte"))
                            field.set(newBean, resultSet.getByte(i));
                        if (field.getType() == Integer.class || strType.equals("int"))
                            field.set(newBean, resultSet.getInt(i));
                        if (field.getType() == Double.class || strType.equals("double"))
                            field.set(newBean, resultSet.getDouble(i));
                        if (field.getType() == Float.class || strType.equals("float"))
                            field.set(newBean, resultSet.getFloat(i));
                        if (field.getType() == Long.class || strType.equals("long"))
                            field.set(newBean, resultSet.getLong(i));
                        if (field.getType() == Short.class || strType.equals("short"))
                            field.set(newBean, resultSet.getShort(i));
                        if (field.getType() == String.class)
                            field.set(newBean, resultSet.getString(i));
                        if (field.getType() == Timestamp.class)
                            field.set(newBean, resultSet.getTimestamp(i));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(newBean);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return beans;
    }

    //метод чтения по ID делает выборку получая все, но с условием.
    public TypeBean read(int id) throws SQLException {
        List<TypeBean> beans = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }


    //команда обновления
    public boolean update(TypeBean bean) throws SQLException {
        // собираем SQL по шаблону
        // "UPDATE `users` SET
        // `Login` = '%s', `Password` = '%s', `Email` = '%s', `FK_Role` = '%d'
        // WHERE `users`.`ID` = %d",
        String sql = "UPDATE " + table + " SET ";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) { //начинаем со второго поля
                Field field = fields[i];
                field.setAccessible(true);
                //добавляем `FieldName` = 'Value', в цикле
                sql = sql.concat(delimiter + "`" + field.getName() + "` = '" + field.get(bean) + "'");
                delimiter = ", "; //добавим запятую перед каждым последующим полем
            }
            fields[0].setAccessible(true);
            sql = sql.concat(" WHERE `" + fields[0].getName() + "` = '" + fields[0].get(bean) + "'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //System.out.println(sql);
        return (0 < executeUpdate(sql, false));
    }

    public boolean create(TypeBean bean) throws SQLException {
        // собираем SQL по шаблону
        // insert INTO users(Login,Password,Email,FK_Role)
        // values('%s','%s','%s',%d)
        String names = "";
        String values = "";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) { //начинаем со второго поля
                Field field = fields[i];
                field.setAccessible(true);
                names = names.concat(delimiter + field.getName());
                values = values.concat(delimiter + "'" + field.get(bean) + "'");
                delimiter = ", "; //добавим запятую перед каждым последующим полем
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String sql = "insert INTO " + table + " (" + names + ") values(" + values + ");";
        //System.out.println(sql);
        int id = executeUpdate(sql, true);
        if (id > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(bean, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (id > 0);
    }


    public boolean delete(TypeBean bean) throws SQLException {
        String sql = null;
        try {
            sql = "DELETE FROM " + table + " WHERE " + table + ".id = " + fields[0].get(bean) + ";";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql, false));
    }


    //т.к. в Generics невозможно сделать new TypeBean(), а новые объекты нужны,
    //создадим объект и приведем его тип к TypeBean "вручную"
    @SuppressWarnings("unchecked") //подавление warning-а
    private TypeBean newBean() {
        try {
            return (TypeBean) bean.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null; //если не создался вернем null
    }


    //общая команда для Create Update Delete
    private static int executeUpdate(String sql, boolean returnLastID) throws SQLException {
        int result;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            //получим ID, если это требуется извне.
            if (result > 0 && returnLastID) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }

}