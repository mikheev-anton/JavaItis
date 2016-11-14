package service;

import dao.UsersDao;
import model.User;
import verify.Verifier;
import verify.VerifierImpl;

import java.util.List;


// слой сервисов приложения - это слой с бизнес-логикой
// определенные алгоритмы в системе
public class UserServiceImpl implements UserService {

    private UsersDao usersDao;
    private Verifier verifier;

    public UserServiceImpl(UsersDao usersDao, Verifier verifier) {
        this.usersDao = usersDao;
        this.verifier = verifier;
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

    public void addUser(User user) {
        usersDao.save(user);
    }

    public User getUser(int id) {
        verifier.userExist(id);
        return usersDao.find(id);
    }
}
