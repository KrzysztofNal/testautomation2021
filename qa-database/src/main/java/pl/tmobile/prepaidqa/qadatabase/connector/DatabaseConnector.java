package pl.tmobile.prepaidqa.qadatabase.connector;

import pl.tmobile.prepaidqa.qadatabase.config.QaDatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            initConnection();
        }
        return connection;
    }

    private static void initConnection() {
        try {
            Class.forName(QaDatabaseConfig.DB_CLASS);
            String url = QaDatabaseConfig.DB_URL;
            String user = QaDatabaseConfig.DB_USER;
            String pass = QaDatabaseConfig.DB_PASS;

            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
