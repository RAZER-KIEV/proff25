package week3_lesson5;

import org.junit.Before;
import org.junit.Test;
import week3_lesson6.Person;

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