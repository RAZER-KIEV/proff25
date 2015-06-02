package session5.singleton;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IEvgen Boldyr on 01.06.15.
 * Project: proff25
 */
public class SingletonTest {

    Singleton singleton;

    @Before
    public void setUp() {
        singleton = Singleton.getInstance();
    }

    @Test
    public void testGetInstance() {
        boolean actual = singleton.equals(Singleton.getInstance());
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
