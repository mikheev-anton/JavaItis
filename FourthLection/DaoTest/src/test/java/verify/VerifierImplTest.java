package verify;

import dao.UsersDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static data.UserTestData.*;

@RunWith(MockitoJUnitRunner.class)
public class VerifierImplTest {

    @Mock
    private UsersDao usersDao;

    private Verifier verifier;

    @Before
    public void setUp() throws Exception {
        verifier = new VerifierImpl(usersDao);
        when(usersDao.contains(anyInt())).thenReturn(false);
        when(usersDao.contains(ID_NASTYA)).thenReturn(true);
        when(usersDao.contains(ID_MARSEL)).thenReturn(true);
        when(usersDao.contains(ID_ILYA)).thenReturn(true);
        when(usersDao.contains(ID_VITYA)).thenReturn(true);
    }

    @Test
    public void testUserExist() throws Exception {
        verifier.userExist(ID_MARSEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserExistIncorrect()throws Exception{
        verifier.userExist(14);
    }
}