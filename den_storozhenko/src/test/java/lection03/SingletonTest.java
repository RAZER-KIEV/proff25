package lection03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Taras on 01.06.2015.
 */
public class SingletonTest {
    Singleton singleton;

    @Before
    public void setUp(){
        singleton = Singleton.getInstance();
    }

    @Test
    public void testSingleton() {
        Singleton actual = singleton;
        Singleton expected = Singleton.getInstance();
        assertEquals(expected,actual);
    }


}
