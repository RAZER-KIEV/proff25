package session5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 01.06.15
 */
public class PersonTest {
    Person module;

    @Before
    public void setUp() {
        module = new Person();
    }

    @Test
    public void testEqualsLegal() {
        boolean actual = module.equals(new Person());
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
