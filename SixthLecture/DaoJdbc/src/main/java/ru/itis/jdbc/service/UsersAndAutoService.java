package ru.itis.jdbc.service;


import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;

import java.util.List;

public class UsersAndAutoService implements UserService {

    private UserDao userDao;
    private CarDao carDao;

    public UsersAndAutoService(UserDao userDao, CarDao carDao) {
        this.userDao = userDao;
        this.carDao = carDao;
    }

    @Override
    public boolean isRegistered(String name) {
        return userDao.isExist(name);
    }

    @Override
    public void addUser(User user) {
        List<Car> cars = user.getCars();
        userDao.save(user);
        for (Car car : cars){
            carDao.save(car, user.getId());
        }
    }

    @Override
    public User getUser(int id) {
        User user = userDao.find(id);
        user.setCars(carDao.findAllUserCars(id));
        return user;
    }

    @Override
    public void update(User user) {
        List<Car> cars = user.getCars();
        userDao.update(user);
        for (Car car : cars){
            carDao.update(car);
        }
    }

    @Override
    public List<User> getUsersByCity(String cityName){
        List<User> usersByCity = userDao.getUsersByCity(cityName);
        for (User user : usersByCity){
            user.setCars(carDao.findAllUserCars(user.getId()));
        }
        return usersByCity;
    }
}
