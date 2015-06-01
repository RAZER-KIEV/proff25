package homework2;

/**
 * Created by bosyi on 29.05.15.
 */
public class ParkingTest {
    public static void main(String[] args) throws Exception {
        Parking parking = new Parking(4);
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");
        Car car5 = new Car("5");

        parking.park(car1);
        parking.park(car2);
        parking.park(car3);
//        parking.park(car4);
//        parking.park(car5);
        parking.leave(3);
    }
}
