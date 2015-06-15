package Homework2;

import java.io.IOException;

/**
 * Created by just1ce on 28.05.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException, ParkFullException {

        TestFreq t2= new TestFreq();
        t2.test();
        AuthTest test = new AuthTest();
        test.test();
        ParkingTest t1= new ParkingTest();
        t1.test();

        //UserTest t = new UserTest();
        //t.test();
    }
}
