package service;

import model.User;

public interface UserService {
    boolean isRegistered(String name);
    void addUser(User user);
    User getUser(int id);
}
