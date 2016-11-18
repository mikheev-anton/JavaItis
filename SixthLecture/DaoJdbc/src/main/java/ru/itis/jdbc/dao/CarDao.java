package ru.itis.jdbc.dao;

import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;

import java.util.List;

public interface CarDao {
    List<Car> findAllCars(int userId);

    void update(Car car,int userId);

    void save(Car car, int userId);

    Car find(int id, int userId);

    void delete(int id, int userId);
}
