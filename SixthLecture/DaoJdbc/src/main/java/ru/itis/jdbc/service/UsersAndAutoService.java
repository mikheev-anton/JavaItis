package ru.itis.jdbc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.Car;
import ru.itis.jdbc.model.User;

import java.util.List;

@Service
public class UsersAndAutoService implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CarDao carDao;

    public UsersAndAutoService(UserDao userDao, CarDao carDao) {
        this.userDao = userDao;
        this.carDao = carDao;
    }

    @Override
    public boolean isRegistered(String email) {
        return userDao.isExist(email);
    }

    @Override
    public void addUser(User user) {
        List<Car> cars = user.getCars();
        userDao.save(user);
        if (cars != null){
            for (Car car : cars){
                carDao.save(car, user.getId());
            }
        }
    }

    @Override
    public User getUser(int id) {
        User user = userDao.find(id);
        user.setCars(carDao.findAllUserCars(id));
        return user;
    }

    @Override
    public User getUser(String email) {
        User user = userDao.find(email);
        user.setCars(carDao.findAllUserCars(user.getId()));
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

    @Override
    public List<User> getAll() {
        List<User> all = userDao.findAll();
        for (User u : all){
            u.setCars(carDao.findAllUserCars(u.getId()));
        }
        return all;
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void save(User user) {
        List<Car> cars = user.getCars();
        userDao.save(user);
        for (Car c : cars){
            carDao.save(c,user.getId());
        }
    }
}
