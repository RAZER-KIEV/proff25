package lection02;

import lection02.homework.Auth;
import lection02.homework.User1;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by Lapchenko on 02.06.2015.
 */
public class AuthTest {
    Auth auth;

    @Before
    public void setUp(){
        auth = new Auth();
    }

    @Test
    public void testAdd(){
        auth.add("A","a");
        auth.add("B","b");
        assertEquals(true,auth.getSet().contains(new User1("A","a")));
        assertEquals(true,auth.getSet().contains(new User1("B","b")));
        assertEquals(false,auth.getSet().contains(new User1("A","b")));
    }

    @Test
    public void testAuthenticate() {
        auth.add("A","a");
        auth.add("B","b");
        assertEquals(true,auth.authenticate("A","a"));
        assertEquals(true,auth.authenticate("B","b"));
        assertEquals(false,auth.authenticate("A","b"));
    }

    @Test
    public void testRemove(){
        User1 u1 = new User1("A");
        User1 u2 = new User1("B");
        User1 u3 = new User1("C");
        auth.add(u1.getLogin(),u1.getPassword());
        auth.add(u2.getLogin(),u2.getPassword());
        auth.add(u3.getLogin(),u3.getPassword());
        auth.remove(u1.getLogin());
        auth.remove(u3.getLogin());
        assertEquals(false, auth.getSet().contains(u1));
        assertEquals(true, auth.getSet().contains(u2));
        assertEquals(false, auth.getSet().contains(u3));
    }
}
