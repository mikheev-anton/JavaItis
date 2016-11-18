package ru.itis.jdbc.dao.jdbc;

import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoJdbcImpl implements CarDao {

    // language=SQL
    private static final String SQL_SELECT_CAR = "SELECT * FROM cars WHERE id = ? AND user_id = ?;";
    // language=SQL
    private static final String SQL_INSERT_CARS = "INSERT INTO cars(car_model, car_number, car_type, user_id)" +
            " VALUES(?, ?, ?, ?);";
    // language=SQL
    private static final String SQL_UPDATE_CARS = "UPDATE cars SET id= ?, car_number = ?,car_model = ?, car_type = ?" +
            " WHERE id = ? AND user_id = ?;";
    // language=SQL
    private static final String SQL_DELETE_CARS = "DELETE FROM cars WHERE id=? AND user_id=?;";
    // language=SQL
    private static final String SELECT_ALL_CARS = "SELECT * FROM cars WHERE user_id=?";

    private final Connection connection;

    public CarDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Car> findAllCars(int userId) {
        List<Car> resultList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CARS);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("car_type");
                String model = resultSet.getString("car_model");
                String number = resultSet.getString("car_number");
                int ownerId = resultSet.getInt("user_id");
                resultList.add(new Car(id,type,model,number,ownerId));
            }
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }

        return resultList;
    }

    public void update(Car car, int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_CARS);
            statement.setInt(1, car.getId());
            statement.setString(2, car.getNumber());
            statement.setString(3,car.getModel());
            statement.setString(4,car.getType());
            statement.setInt(5, car.getId());
            statement.setInt(6, userId);
            statement.execute();
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public void save(Car car, int userId) {
        try {
//            Statement stmt = connection.createStatement();
//
//            String query = "select currval('cars_id_seq')";
//            ResultSet rs = stmt.executeQuery(query);
//            rs.next();
//            int carId = rs.getInt(1);

            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_CARS);
            statement.setString(1, car.getNumber());
            statement.setString(2,car.getModel());
            statement.setString(3,car.getType());
            statement.setInt(4, userId);
            statement.execute();
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public Car find(int id, int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CAR);
            statement.setInt(1, id);
            statement.setInt(2, userId);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int carId = resultSet.getInt("id");
            String type = resultSet.getString("car_type");
            String model = resultSet.getString("car_model");
            String number = resultSet.getString("car_number");
            int ownerId = resultSet.getInt("user_id");
            return new Car(carId,type,model,number,ownerId);

        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public void delete(int id, int userId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CARS);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, userId);
            preparedStatement.execute();
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }
}
