package ru.itis.jdbc.dao.jdbc;

import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.User;

import java.sql.Connection;
import java.util.List;

public class UserJdbcDaoImpl implements UserDao {

    // language=SQL
    private static final String SQL_SELECT_USER = "SELECT * FROM users WHERE id = ?;";
    // language=SQL
    private static final String SQL_INSERT_USER = "INSERT INTO users(id, name, email, password)" +
            " VALUES(?, ?, ?, ?);";
    // language=SQL
    private static final String SQL_UPDATE_USER = "UPDATE users SET id= ?, name = ?, password = ?, email = ?" +
            " WHERE id = ?";
    // language=SQL
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id=?";
    // language=SQL
    private static final String SELECT_ALL_USER = "SELECT * FROM users WHERE id=?";

    private final Connection connection;

    public UserJdbcDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() {
        return null;
    }

    public void update(User user) {

    }

    public void save(User user) {

    }

    public User find(int id) {
        return null;
    }

    public void delete(int id) {

    }
}
