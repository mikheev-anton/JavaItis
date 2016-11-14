import dao.UserDaoFileImpl;
import dao.UserDaoFileStringImpl;
import dao.UsersDao;
import model.User;
import service.UserService;
import service.UserServiceImpl;
import verify.VerifierImpl;

public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007",0);
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008",1);
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009",2);

        UsersDao usersDao = new UserDaoFileStringImpl("src\\main\\resourse\\users_string.txt");
        System.out.println(marsel);
        usersDao.save(marsel);
        usersDao.save(nastya);
        usersDao.save(ilya);

        UserService userService = new UserServiceImpl(usersDao, new VerifierImpl());

        if (userService.isRegistered("Marsel")) {
            System.out.println("Marsel is Registered");
        } else {
            System.out.println("not registered");
        }
    }
}
