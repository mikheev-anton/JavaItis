package ru.itis.jdbc.service;


import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public Car find(int id) {
        return carDao.find(id);
    }

    @Override
    public void save(Car car, int userId) {
        carDao.save(car, userId);
    }

    @Override
    public void delete(int id) {
        carDao.delete(id);
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public List<Car> getCarsByCity(String userCity) {
        return carDao.getCarsByCity(userCity);
    }
}
