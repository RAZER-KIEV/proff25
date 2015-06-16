package session5.creator.singleton;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by oleg on 01.06.15.
 */
public class SingletonTes {

    Singleton instance;

    @Before
    public void setUp() {
        instance = Singleton.getInstance();
    }

    @Test
    public void test() {

        Singleton newInstance = Singleton.getInstance();
        assertEquals(instance, newInstance);
    }
}