package ru.itis.jdbc.service;


import ru.itis.jdbc.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car find(int id);
    void save(Car user, int userId);
    void delete(int id);
    void update(Car user);
    List<Car> getCarsByCity(String userCity);
}
