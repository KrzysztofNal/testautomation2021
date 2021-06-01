package pl.tmobile.prepaidqa.qadatabase.dao;

import pl.tmobile.prepaidqa.qadatabase.connector.DatabaseConnector;
import pl.tmobile.prepaidqa.qadatabase.model.UserDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static List<UserDb> getAllUserDb() {

        List<UserDb> users = new ArrayList<>();

        String sql = "select * from testuser";

        Statement statement = null;
        ResultSet wynik = null;

        try {
            statement = DatabaseConnector.getConnection().createStatement();
            wynik = statement.executeQuery(sql);

            while (wynik.next()) {
                String id = wynik.getString("id");
                String name = wynik.getString("name");
                String surname = wynik.getString("surname");
                UserDb userDb = new UserDb(id, name, surname);
                users.add(userDb);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                wynik.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return users;
    }

    public static UserDb getUserDbById(String userId) {

        String sql = "select * from testuser where id = " + userId;

        UserDb userDb = null;

        Statement statement = null;
        ResultSet wynik = null;

        try {
            statement = DatabaseConnector.getConnection().createStatement();
            wynik = statement.executeQuery(sql);

            while (wynik.next()) {
                String id = wynik.getString("id");
                String name = wynik.getString("name");
                String surname = wynik.getString("surname");
                userDb = new UserDb(id, name, surname);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                wynik.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return userDb;

    }

    public static void saveUser(UserDb userDb) {
        String sql = "insert into testuser (id, name, surname) values (" + userDb.id + ", '" + userDb.name + "', '" + userDb.surname + "')";

        Statement statement = null;
        try {
            statement = DatabaseConnector.getConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void deleteUser(String id) {
        String sql = "delete testuser where id = '" + id + "'";
        Statement statement = null;
        try {
            statement = DatabaseConnector.getConnection().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void updateUser(UserDb userDb, String id) {
        String sql = "update testuser set id = '" + userDb.id + "', name = '" + userDb.name + "', surname = '" + userDb.surname + "' where id = '" + id + "'";

        Statement statement = null;
        try {
            statement = DatabaseConnector.getConnection().createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }



}
