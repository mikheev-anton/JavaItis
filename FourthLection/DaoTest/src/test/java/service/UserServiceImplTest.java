package service;

import dao.UsersDao;
import data.UserTestData;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import verify.Verifier;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static data.UserTestData.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UsersDao usersDao;

    @Mock
    private Verifier verifier;

    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        // создали мок-объект, объект с временной реализацией
        // usersDao = mock(UsersDao.class);
        userService = new UserServiceImpl(usersDao, verifier);

        User user = new User("Vasya", "javaProgrammist", "qwerty007",5);
        User defaultUser = new User("DEFAULT", "DEFAULT", "DEFAULT",6);
        when(usersDao.findAll()).thenReturn(UserTestData.TEST_DATA);
        when(usersDao.find(anyInt())).thenReturn(defaultUser);
        when(usersDao.find(2)).thenReturn(user);

        doThrow(IllegalArgumentException.class).when(verifier).userExist(anyInt());
        doNothing().when(verifier).userExist(ID_MARSEL);
        doNothing().when(verifier).userExist(ID_ILYA);
        doNothing().when(verifier).userExist(ID_VITYA);
        doNothing().when(verifier).userExist(ID_NASTYA);
    }

    @Test
    public void isRegistered() throws Exception {
        boolean actual = userService.isRegistered("Marsel");
        assertTrue(actual);
    }

    @Test
    public void getUser() throws Exception {
        String actualName = userService.getUser(2).getName();
        String expectedName = "Vasya";
        // проверяем, вызвал ли был вообще метод userExist
        verify(verifier).userExist(2);
        assertEquals(actualName, expectedName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUserOnIncorrectData() throws Exception {
        userService.getUser(3);
    }

    @Test
    public void testUpdate()throws Exception{
        userService.update(new User("hgf","ferfe","efref",ID_NASTYA));
        verify(usersDao).update(new User("hgf","ferfe","efref",ID_NASTYA));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateOnIncorrectData()throws Exception{
        userService.update(new User("U","uu","yt", 7));
    }
}