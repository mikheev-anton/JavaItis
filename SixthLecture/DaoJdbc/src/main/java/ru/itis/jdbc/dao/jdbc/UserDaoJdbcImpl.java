package ru.itis.jdbc.dao.jdbc;

import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.itis.jdbc.dao.jdbc.SqlQuery.*;

public class UserDaoJdbcImpl implements UserDao {

    private final Connection connection;

    public UserDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USER);
            while (resultSet.next()) {
                users.add(convertIntoUser(resultSet));
            }
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
        return users;
    }

    public void update(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getCity());
            statement.setInt(4,user.getId());
            statement.execute();
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public void save(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getCity());
            statement.execute();
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public User find(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            int userId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String city = resultSet.getString("city");

            return new User(userId,name,age,city);
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> getUsersByCity(String cityName) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_BY_CITY);
            statement.setString(1, cityName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(convertIntoUser(resultSet));
            }
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
        return users;
    }

    @Override
    public boolean isExist(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_COUNT_USER);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt("count");
            return count != 0;
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    private User convertIntoUser(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String city = resultSet.getString("city");
        return new User(id,name,age,city);
    }
}
