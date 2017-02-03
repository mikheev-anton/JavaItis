package ru.itis.jdbc.dao;

import ru.itis.jdbc.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void update(User user);

    void save(User user);

    User find(int id);

    User find(String email);

    void delete(int id);

    List<User> getUsersByCity(String cityName);

    boolean isExist(String email);
}
