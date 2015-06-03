package session5;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Роман on 01.06.2015.
 */
public class SingletonTest {

    Singleton module;

    @Before
    public void setUp() {
        module = Singleton.getInstance();
    }

    @Test
    public void testGetInstanceLegal() {
        Singleton actual = Singleton.getInstance();
        Singleton expected = module;
        assertEquals(expected, actual);
    }
}
