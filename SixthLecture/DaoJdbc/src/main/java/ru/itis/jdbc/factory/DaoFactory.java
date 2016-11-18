package ru.itis.jdbc.factory;


import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.factory.loaders.PropertyLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

public class DaoFactory {
    private static final DaoFactory INSTANCE;

    private UserDao userDao;
    private CarDao carDao;

    static {
        INSTANCE = new DaoFactory();
    }

    private DaoFactory(){
        PropertyLoader.loadIocConfig();
        try {
            String userDaoName = PropertyLoader.getProperty("dao.user.class");
            String carDaoName = PropertyLoader.getProperty("dao.car.class");
            String type = PropertyLoader.getProperty("dao.type");
            if ("db".equals(type)){
                Connection connection = ConnectionFactory.getInstance().getConnection();
                Constructor<?> userDaoConstructor = Class.forName(userDaoName).getConstructor(Connection.class);
                userDao = (UserDao) userDaoConstructor.newInstance(connection);

                Constructor<?> carDaoConstructor = Class.forName(carDaoName).getConstructor(Connection.class);
                carDao = (CarDao)carDaoConstructor.newInstance(connection);
            }
        } catch ( ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
    public static DaoFactory getInstance(){
        return INSTANCE;
    }

    public UserDao getDao(){
        return userDao;
    }

    public CarDao getCarDao() {
        return carDao;
    }
}
