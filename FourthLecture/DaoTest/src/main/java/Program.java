import dao.UserDaoFileImpl;
import dao.UserDaoFileStringImpl;
import dao.UsersDao;
import factories.ServiceFactory;
import model.User;
import service.UserService;
import service.UserServiceImpl;
import verify.VerifierImpl;

public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007",0);
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008",1);
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009",2);

        UserService userService = ServiceFactory.getInstance().getUserService();

        userService.addUser(marsel);
        userService.addUser(nastya);
        userService.addUser(ilya);

        if (userService.isRegistered("Marsel")) {
            System.out.println("Marsel is Registered");
        } else {
            System.out.println("not registered");
        }
    }
}
