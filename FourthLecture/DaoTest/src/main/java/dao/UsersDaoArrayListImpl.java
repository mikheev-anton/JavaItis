package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoArrayListImpl implements UsersDao {

    private List<User> users;

    public UsersDaoArrayListImpl() {
        this.users = new ArrayList<User>();
    }
    public List<User> findAll() {
        return this.users;
    }

    public void update(User user) {
        if (users.contains(user)){
            users.remove(user.getId());
        }
        users.add(user);
    }

    public void save(User user) {
        User userForSave = new User(user.getName(), user.getLogin(), user.getPassword(),user.getId());
        this.users.add(userForSave);
    }

    public User find(int id) {
        return users.get(id);
    }

    public void delete(int id) {
        users.remove(id);
    }

    @Override
    public void clean() {
        users.clear();
    }

    @Override
    public boolean contains(int id) {
        for (User u : users){
            if (u.getId() == id)
                return true;
        }
        return false;
    }
}
