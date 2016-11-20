package ru.itis.jdbc.verify;

import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.factory.DaoFactory;

public class VerifierImpl implements Verifier {

    private UserDao userDao;

    public VerifierImpl() {
        this.userDao = DaoFactory.getInstance().getUserDao();
    }

    public VerifierImpl(UserDao userDao){
        this.userDao = userDao;
    }

    public void userExist(int userId) {
//        boolean isExist = userDao.contains(userId);
        // запрос в файл/бд проверки, есть там пользователь или нет
//        if (!isExist) {
//            throw new IllegalArgumentException("User not found");
//        }
    }
}
