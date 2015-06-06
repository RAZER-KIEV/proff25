package session5;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by just1ce on 01.06.2015.
 */
public class SingletonTest {
    Singleton module;
    @Before
    public void setUp(){
        module = Singleton.getInstance();
    }
    @Test
    public void testUniq(){
        Singleton actual = Singleton.getInstance();
        assertFalse(actual!=module);

    }
}
