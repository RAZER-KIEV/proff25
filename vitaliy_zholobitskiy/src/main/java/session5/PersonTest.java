package session5;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by just1ce on 01.06.2015.
 */
public class PersonTest {
    Person module;
    @Before
    public void setUp(){
        module = new Person();
    }
    @Test
    public void testEqualsLegal(){
        boolean actual = module.equals(new Person());
        boolean expected = true;
        assertEquals(expected,actual);
    }
    @Test
    public void testEqualsLegal1(){
        boolean actual = module.equals(new Person());
        boolean expected = true;
        assertEquals(expected,actual);
    }
}
