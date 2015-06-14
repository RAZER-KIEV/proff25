package week3_lesson5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by HP on 01.06.2015.
 */
public class TestSingleton {
    Singleton module1;
    @Before
    public void setUp() {
        module1 = Singleton.getInstance();
    }
    @Test
    public void testEqualsLegal() {
        boolean actual = module1.equals(Singleton.getInstance());
        boolean expected = true;
        assertEquals(expected, actual);
    }
}