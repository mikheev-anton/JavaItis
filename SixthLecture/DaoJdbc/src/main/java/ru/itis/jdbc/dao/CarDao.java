package ru.itis.jdbc.dao;

import ru.itis.jdbc.model.Car;

import java.util.List;

public interface CarDao {
    List findAllUserCars(int userId);

    List<Car> findAll();

    void update(Car car);

    void save(Car car, int userId);

    Car find(int id);

    void delete(int id);

    List<Car> getCarsByCity(String userCity);
}
