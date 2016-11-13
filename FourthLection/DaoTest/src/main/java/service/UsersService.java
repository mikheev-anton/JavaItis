package service;

import dao.UsersDao;
import model.User;

import java.util.List;

// слой сервисов приложения - это слой с бизнес-логикой
// определенные алгоритмы в системе
public class UsersService implements UserService {

    private UsersDao usersDao;

    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();

        for (User currentUser : users) {
            if (currentUser.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
