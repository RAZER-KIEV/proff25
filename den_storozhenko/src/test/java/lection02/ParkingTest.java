package lection02;

import lection02.homework.Car;
import lection02.homework.ParkFullExeption;
import lection02.homework.Parking;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
public class ParkingTest {
    Parking parking;

    @Before
    public void setUp(){
        parking = new Parking(5);
    }

    @Test
    public void testPark() throws ParkFullExeption {
        try {
        assertEquals(0, parking.park(new Car(new Random().nextInt())));
        assertEquals(1, parking.park(new Car(new Random().nextInt())));
        assertEquals(2, parking.park(new Car(new Random().nextInt())));
            assertEquals(3, parking.park(new Car(new Random().nextInt())));
            assertEquals(4, parking.park(new Car(new Random().nextInt())));
        assertEquals(new ParkFullExeption(), parking.park(new Car(new Random().nextInt())));

       } catch (ParkFullExeption parkFullExeption) {}
    }

    @Test
    public void testLeave() throws ParkFullExeption {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();

        parking.park(car1);
        parking.park(car2);
        parking.park(car3);
        parking.park(car4);
        parking.park(car5);
        //try {
        assertEquals(car1, parking.leave(0));
        assertEquals(car2, parking.leave(1));
        //assertEquals(new IndexOutOfBoundsException(), parking.leave(5));
        //}catch ( ex){

        //}
    }
}
