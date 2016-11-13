import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SomeMethodsTest {

    // объявляем поле типа тестируемого класса
    private SomeMethods testingSomeMethods;

    @Before
    public void setUp() throws Exception {
        testingSomeMethods = new SomeMethods();
    }

    // каждый тест пишется на отдельный метод
    // в идеале проверяет один случай
    @Test
    public void testSum() throws Exception {
        int expected = 11;

        int actual = testingSomeMethods.sum(5, 6);

        assertEquals(expected, actual);
    }

}