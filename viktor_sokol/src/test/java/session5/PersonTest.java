package session5;

/**
 * Created by Віктор on 6/1/2015.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
