package ru.itis.jdbc.service;


import ru.itis.jdbc.model.User;

import java.util.List;

public interface UserService {
    boolean isRegistered(String name);
    void addUser(User user);
    User getUser(int id);
    void update(User user);
    public List<User> getUsersByCity(String cityName);
}