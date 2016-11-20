package ru.itis.jdbc.dao.jdbc;

import org.junit.Before;
import org.junit.Test;
import ru.itis.jdbc.dao.UserDao;
import ru.itis.jdbc.factory.ConnectionFactory;
import ru.itis.jdbc.factory.DaoFactory;
import ru.itis.jdbc.model.User;

import java.util.List;

import static org.junit.Assert.*;


public class UserDaoJdbcImplTest {

    private UserDaoJdbcImpl userDao;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDaoJdbcImpl(ConnectionFactory.getInstance().getConnection());
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> all = userDao.findAll();
        for (User u : all){
            System.out.println(u);
        }
    }

    @Test
    public void testUpdate() throws Exception {
        userDao.update(new User(5,"rere",66,"rjkz"));
        System.out.println(userDao.find(5));
    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testFind() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetUsersByCity() throws Exception {

    }

    @Test
    public void testIsExist() throws Exception {

    }
}