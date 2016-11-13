package dao;

import com.google.common.collect.Lists;
import model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsersDaoArrayListImplTest {

    private final static List<User> TEST_DATA = getTestUsers();

    private static List<User> getTestUsers() {
        User marsel = new User("Marsel", "marselLogin", "qwerty007");
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008");
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009");

        return Lists.newArrayList(marsel, nastya, ilya);
    }

    private UsersDaoArrayListImpl testingUsersDao;

    @Before
    public void setUp() throws Exception {
        testingUsersDao = new UsersDaoArrayListImpl();
        prepareTestData();
    }

    private void prepareTestData() {
        testingUsersDao.save(TEST_DATA.get(0));
        testingUsersDao.save(TEST_DATA.get(1));
        testingUsersDao.save(TEST_DATA.get(2));
    }

    @Test
    public void findAll() throws Exception {
        List<User> expected = TEST_DATA;

        List<User> actual = testingUsersDao.findAll();

        assertEquals(expected, actual);
    }

}