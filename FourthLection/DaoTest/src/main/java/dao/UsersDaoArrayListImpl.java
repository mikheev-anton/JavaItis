package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoArrayListImpl implements UsersDao {

    List<User> users;

    public UsersDaoArrayListImpl() {
        this.users = new ArrayList<User>();
    }
    public List<User> findAll() {
        return this.users;
    }

    public void save(User user) {
        User userForSave = new User(user.getName(), user.getLogin(), user.getPassword());
        this.users.add(userForSave);
    }
}
