package session5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by viktoria
 * Project:.session5
 */
public class SingletonTest {
    Singleton singleton;


    @Before
    public void setInstance(){
        singleton = Singleton.getInstance();
    }

    @Test
    public void testEqualsLegal(){
        boolean actual = singleton.equals(Singleton.getInstance());
        boolean expected = true;
        assertEquals(expected, actual);
    }
}
