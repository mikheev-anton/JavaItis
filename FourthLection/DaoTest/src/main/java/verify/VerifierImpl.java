package verify;


import dao.UsersDao;
import factories.DaoFactory;

public class VerifierImpl implements Verifier {

    private UsersDao usersDao;

    public VerifierImpl() {
        this.usersDao = DaoFactory.getInstance().getDao();
    }

    public VerifierImpl(UsersDao usersDao){
        this.usersDao = usersDao;
    }

    public void userExist(int userId) {
        boolean isExist = usersDao.contains(userId);
        // запрос в файл/бд проверки, есть там пользователь или нет
        if (!isExist) {
            throw new IllegalArgumentException("User not found");
        }
    }
}
