package session5;

/**
 * Created by bosyi on 01.06.15.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SingletonExTest {
    private SingletonEx module;
    @Before
    public void setUp() {
        module = SingletonEx.getInstance();
    }
    @Test
    public void testEqualsLegal() {
        boolean actual = module.equals(SingletonEx.getInstance());
        boolean expected = true;
        assertEquals(expected, actual);
    }

}
