package hw2.lab.authentication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ПК on 02.06.2015.
 */
public class AuthTest {
    Auth testAuth= new Auth();

    @Before
    public void setup() { testAuth = new Auth();  }

    @Test
    public void completeLegalTest() {
        boolean firstest = testAuth.authenticate("Razer","somepath");
        testAuth.add("RAzer", "somepass");
        boolean secondtest = testAuth.authenticate("RAzer", "somepass");
        boolean firstres= false;
        boolean secres = true;
        assertEquals(firstest,firstres);
        assertEquals(secondtest, secres);
    }
    @Test
    public void addtwiceTest(){
        testAuth.add("RAzer", "somepass");
        testAuth.add("RAzer", "sOmepass");
        boolean needTrue = testAuth.authenticate("RAzer", "somepass");
        boolean needFaulse = testAuth.authenticate("RAzer", "sOmepass");
        assertEquals(needTrue,true);
        assertEquals(needFaulse,false);
    }
}
