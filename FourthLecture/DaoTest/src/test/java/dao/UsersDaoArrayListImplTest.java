package dao;

import model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static data.UserTestData.*;

public class UsersDaoArrayListImplTest {

    private UsersDaoArrayListImpl testingUsersDao;

    @Before
    public void setUp() throws Exception {
        testingUsersDao = new UsersDaoArrayListImpl();
        prepareTestData();
    }

    public void prepareTestData() {
        testingUsersDao.save(MARSEL);
        testingUsersDao.save(NASTYA);
        testingUsersDao.save(ILYA);
        testingUsersDao.save(VIIITYA);
    }

    @Test
    public void findAll() throws Exception {
        List<User> expected = TEST_DATA;

        List<User> actual = testingUsersDao.findAll();

        assertEquals(expected, actual);
    }

}