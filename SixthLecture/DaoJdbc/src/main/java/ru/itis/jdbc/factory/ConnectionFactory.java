package ru.itis.jdbc.factory;

import ru.itis.jdbc.factory.loaders.PropertyLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final ConnectionFactory INSTANCE;

    private Connection connection;

    static {
        INSTANCE = new ConnectionFactory();
    }

    private ConnectionFactory() {
        PropertyLoader.loadDBConfig();
        try {
            Class.forName(PropertyLoader.getProperty("jdbc.driver"));
            String url = PropertyLoader.getProperty("pq.url");
            String user = PropertyLoader.getProperty("pq.name");
            String password = PropertyLoader.getProperty("pq.password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static ConnectionFactory getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        return connection;
    }
}
