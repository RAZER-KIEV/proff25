package session5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Роман on 01.06.2015.
 */
public class PersonTest {
    Person module;
//    public static void main(String[] args) {
//        PersonTest driver = new PersonTest();
//        driver.testEqualsLegal();
//    }
    @Before
    public void setUp() {
        module = new Person();
    }

    @Test
    public void testEqualsLegal() {
        Person module = new Person();
        boolean actual = module.equals(new Person());
        boolean expected = true;

        assertEquals(expected, actual);

//        if(actual == expected) {
//            System.out.println("Test OK");
//        } else {
//            System.out.println("Test fail");
//        }
    }
}
