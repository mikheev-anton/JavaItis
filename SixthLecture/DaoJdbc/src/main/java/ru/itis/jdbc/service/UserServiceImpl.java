package ru.itis.jdbc.service;


import ru.itis.jdbc.model.User;

import java.util.List;


// слой сервисов приложения - это слой с бизнес-логикой
// определенные алгоритмы в системе
public class UserServiceImpl implements UserService {


    public UserServiceImpl(){
    }

    public boolean isRegistered(String name) {
        return false;
    }

    public void addUser(User user) {
    }

    public User getUser(int id) {
       return null;
    }

    public void update(User user) {
    }
}
