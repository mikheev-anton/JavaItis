package ru.itis.jdbc.factory;

import ru.itis.jdbc.dao.CarDao;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.factory.loaders.PropertyLoader;
import ru.itis.jdbc.service.CarService;
import ru.itis.jdbc.service.UserService;
import ru.itis.jdbc.verify.Verifier;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE;

    private UserService userService;
    private CarService carService;

    static {
        INSTANCE = new ServiceFactory();
    }

    private ServiceFactory() {
        try {
            PropertyLoader.loadIocConfig();
            DaoFactory factory = DaoFactory.getInstance();
            UserDao userDao = factory.getUserDao();
            CarDao carDao = factory.getCarDao();
            String serviceType = PropertyLoader.getProperty("service.type");
            Constructor<?> carServiceConst = Class.forName(PropertyLoader.getProperty("service.car.class")).getConstructor(CarDao.class);
            carService = (CarService) carServiceConst.newInstance(carDao);
            switch (serviceType){
                case "verify.lazy.init":
                    Verifier verifier = (Verifier) Class.forName(PropertyLoader.getProperty("verifier.class")).newInstance();
                    Constructor<?> constructor = Class.forName(PropertyLoader.getProperty("service.user.class")).getConstructor(UserDao.class, Verifier.class);
                    userService = (UserService)constructor.newInstance(userDao,verifier);
                    break;
                case "eager.init":
                    Constructor<?> userServiceConst = Class.forName(PropertyLoader.getProperty("service.user.class")).getConstructor(UserDao.class, CarDao.class);
                    userService = (UserService) userServiceConst.newInstance(userDao, carDao);
                    break;
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public static ServiceFactory getInstance(){
        return INSTANCE;
    }

    public UserService getUserService(){
        return userService;
    }
    public CarService getCarService(){
        return carService;
    }
}
