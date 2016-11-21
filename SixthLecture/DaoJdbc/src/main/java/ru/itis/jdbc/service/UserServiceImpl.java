package ru.itis.jdbc.service;

import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.model.User;
import ru.itis.jdbc.verify.Verifier;

import java.util.List;


// слой сервисов приложения - это слой с бизнес-логикой
// определенные алгоритмы в системе
public class UserServiceImpl implements UserService {

    private UserDao usersDao;
    private Verifier verifier;

    public UserServiceImpl(UserDao usersDao, Verifier verifier){
        this.usersDao = usersDao;
        this.verifier = verifier;
    }

    public boolean isRegistered(String name) {
        return usersDao.isExist(name);
    }

    public void addUser(User user) {
        usersDao.save(user);
    }

    public User getUser(int id) {
        verifier.userExist(id);
        return usersDao.find(id);
    }

    @Override
    public void update(User user) {
        verifier.userExist(user.getId());
        usersDao.update(user);
    }

    @Override
    public List<User> getUsersByCity(String cityName) {
        return usersDao.getUsersByCity(cityName);
    }

    @Override
    public List<User> getAll() {
        return usersDao.findAll();
    }

    @Override
    public void delete(int id) {
        usersDao.delete(id);
    }

    @Override
    public void save(User user) {
        usersDao.save(user);
    }
}
