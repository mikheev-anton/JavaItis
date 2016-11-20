package ru.itis.jdbc.dao;

import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;

import java.util.List;

public interface CarDao {
    List<Car> findAllUserCars(int userId);

    List<Car> findAll();

    void update(Car car);

    void save(Car car, int userId);

    Car find(int id);

    void delete(int id);

    List<Car> getCarsByCity(String userCity);
}
