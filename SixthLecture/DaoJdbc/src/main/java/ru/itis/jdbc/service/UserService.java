package ru.itis.jdbc.service;


import ru.itis.jdbc.model.User;

import java.util.List;

public interface UserService {
    boolean isRegistered(String email);
    void addUser(User user);
    User getUser(int id);
    User getUser(String email);
    void update(User user);
    public List<User> getUsersByCity(String cityName);
    List<User> getAll();
    void delete(int id);
    void save(User user);
}