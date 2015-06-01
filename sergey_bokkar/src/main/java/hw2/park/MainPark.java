package hw2.park;

/**
 * Created by Well on 30.05.2015.
 */
public class MainPark {
    public static void main(String[] args) throws ParkFullException {

        Car car1 = new Car ("bmw");
        Car car2 = new Car ("mers");
        Car car3 = new Car ("lada");
        Car car4 = new Car ("WV");

        Parking park1 = new Parking();

        park1.park(car1);
        park1.park(car2);
        park1.park(car3);
//        park1.park(car4);

        System.out.println(car1.getModel() + " " + car1.getParkPlace());
        System.out.println(car2.getModel() + " " + car2.getParkPlace());
        System.out.println(car3.getModel() + " " + car3.getParkPlace());
        System.out.println(car4.getModel() + " " + car4.getParkPlace());
        System.out.println();
//        System.out.println(park1);

        park1.print();

        park1.leave(2);
        park1.leave(3);
        System.out.println();
        park1.print();

        System.out.println();
//        System.out.println(park1);
        System.out.println(car1.getModel() + " " + car1.getParkPlace());
        System.out.println(car2.getModel() + " " + car2.getParkPlace());
        System.out.println(car3.getModel() + " " + car3.getParkPlace());
        System.out.println(car4.getModel() + " " + car4.getParkPlace());

        park1.park(car2);
        park1.park(car3);
        park1.park(car4);


    }
}
