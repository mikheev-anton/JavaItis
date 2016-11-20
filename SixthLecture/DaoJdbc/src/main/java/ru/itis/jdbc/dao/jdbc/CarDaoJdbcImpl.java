package ru.itis.jdbc.dao.jdbc;

import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.itis.jdbc.dao.jdbc.SqlQuery.*;

public class CarDaoJdbcImpl implements CarDao {

    private final Connection connection;

    public CarDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<Car> findAllUserCars(int userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS_CARS);
            statement.setInt(1, userId);
            return getCars(statement);
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Car> findAll() {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CARS);
            return getCars(statement);
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public void update(Car car) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_CARS);
            statement.setInt(1, car.getId());
            statement.setString(2,car.getModel());
            statement.setInt(3,car.getMileage());
            statement.setInt(4, car.getId());
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
            statement.setString(1,car.getModel());
            statement.setInt(2,car.getMileage());
            statement.setInt(3, userId);
            statement.execute();
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public Car find(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CAR);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int carId = resultSet.getInt("id");
            String model = resultSet.getString("car_model");
            int mileage = resultSet.getInt("car_mileage");
            int ownerId = resultSet.getInt("user_id");
            return new Car(carId,model,mileage,ownerId);

        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_CARS);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Car> getCarsByCity(String userCity) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CARS_BY_CITY);
            statement.setString(1, userCity);
            return getCars(statement);
        }catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    private List<Car> getCars(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        List<Car> resultList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String model = resultSet.getString("car_model");
            int mileage = resultSet.getInt("car_mileage");
            int ownerId = resultSet.getInt("user_id");
            resultList.add(new Car(id,model,mileage,ownerId));
        }
        return resultList;
    }
}
