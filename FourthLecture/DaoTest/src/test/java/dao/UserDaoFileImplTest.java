package dao;

import model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static data.UserTestData.*;
import static org.junit.Assert.*;


public class UserDaoFileImplTest {

    private UserDaoFileImpl testingUsersDao;

    private static final String PATH = "src/test/resourse/test_users.txt";

    @Before
    public void setUp() throws Exception {
        testingUsersDao = new UserDaoFileImpl(PATH);
        testingUsersDao.clean();
        prepareTestData();
    }

    public void prepareTestData() {
        testingUsersDao.save(TEST_DATA.get(0));
        testingUsersDao.save(TEST_DATA.get(1));
        testingUsersDao.save(TEST_DATA.get(2));
        testingUsersDao.save(TEST_DATA.get(3));
    }

    @Test
    public void testUpdate() throws Exception {
        User expected = new User("Update","User","101",ID_ILYA);

        testingUsersDao.update(expected);

        User actual = testingUsersDao.find(ID_ILYA);
        assertEquals(expected, actual);
    }

    @Test
    public void testSave() throws Exception {
        List<User> expected = TEST_DATA;
        User e = new User("Saved", "SU", "jjgg", ID_VITYA + 1);
        expected.add(e);

        testingUsersDao.save(e);

        List<User> actual = testingUsersDao.findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void testFind() throws Exception {
        User expected = MARSEL;
        User actual = testingUsersDao.find(ID_MARSEL);
        assertEquals(expected,actual);
    }

    @Test
    public void testDelete() throws Exception {
        List<User> expected = Arrays.asList(NASTYA, ILYA, VIIITYA);
        testingUsersDao.delete(ID_MARSEL);
        List<User> actual = testingUsersDao.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> expected = TEST_DATA;

        List<User> actual = testingUsersDao.findAll();

        assertEquals(expected, actual);
    }
}