package hw2.park;

public class Main {

    public static void main(String[] args) throws ParkFullException {
        Parking places = new Parking();

        for (int i = 0; i < 10; i++) {
            places.park(new Car());
        }
        System.out.println(places.leave(5));
        places.park(new Car());
        places.park(new Car());
        //places.leave(20);


    }
}
