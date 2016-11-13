import dao.UserDaoFileImpl;
import dao.UsersDao;
import dao.UsersDaoArrayListImpl;
import model.User;
import service.UserService;
import service.UsersService;

public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007");
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008");
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009");

        UsersDao usersDao = new UserDaoFileImpl("C:/java_progect/JavaItis/FourthLection/DaoTest/src/resourse/users.txt");

        usersDao.save(marsel);
        usersDao.save(nastya);
        usersDao.save(ilya);

        UserService userService = new UsersService(usersDao);

        if (userService.isRegistered("Marsel")) {
            System.out.println("Marsel is Registered");
        } else {
            System.out.println("not registered");
        }
    }
}
