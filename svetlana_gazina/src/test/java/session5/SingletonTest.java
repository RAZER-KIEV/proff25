package session5;


import org.junit.Before;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sveta on 6/1/2015.
 */
public class SingletonTest {
    Singleton single1;
    Singleton single2;


    @Test
    public void testEqualsLegal() {
        single1 = Singleton.getInstance();
        single2 = Singleton.getInstance();

        boolean actual = single1.equals(single2);
        boolean expected = true;
        assertEquals(expected, actual);
    }



}
