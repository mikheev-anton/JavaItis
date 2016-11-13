package dao;

import model.User;

import java.util.List;

public interface UsersDao {
    List<User> findAll();
    void save(User user);
}
