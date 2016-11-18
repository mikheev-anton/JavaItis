package factories;

import dao.UsersDao;
import factories.loaders.PropertyLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DaoFactory {
    private static final DaoFactory INSTANCE;

    private UsersDao usersDao;

    static {
        INSTANCE = new DaoFactory();
    }

    private DaoFactory() {
        try {
            String userDaoName = PropertyLoader.getProperty("dao.class");
            Class<?> daoClass = Class.forName(userDaoName);
            String property = PropertyLoader.getProperty("dao.type");
            switch (property){
                case  "file":
                    Constructor constructor = (Constructor)Class.forName(userDaoName).getConstructor(String.class);
                    usersDao = (UsersDao)constructor.newInstance(PropertyLoader.getProperty("file.path"));
                    break;
                default:
                    usersDao = (UsersDao) daoClass.newInstance();
            }
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static DaoFactory getInstance(){
        return INSTANCE;
    }

    public UsersDao getDao(){
        return usersDao;
    }
}
