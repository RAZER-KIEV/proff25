package hw2.park;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Well on 28.05.2015.
 */
public class Parking {
    Map<Integer, Car> parking = new HashMap<>();
    final int PARKING_SIZE = 3;

    public Parking(){
//       for (int i = 1; i <= PARKING_SIZE; i++){
//            parking.put(i, null);
//        }
    }

    public int park(Car car) throws ParkFullException {

        Integer placeNumber = freePlace();

        if (placeNumber == null) {
            throw new ParkFullException();
        }

//        if (placeNumber > PARKING_SIZE) {
//            throw new IndexOutOfBoundsException();
//        }


            parking.put(placeNumber, car);
            car.setParkPlace(placeNumber);
            return placeNumber;


    }

    public Car leave(int placeNumber) {

//        Integer pn = (Integer) placeNumber;

        if (placeNumber > PARKING_SIZE) {
            throw new IndexOutOfBoundsException();
        }

        Car car = parking.remove(placeNumber);
        car.setParkPlace(0);
//        parking.remove(placeNumber);

        return car;
    }

    private Integer freePlace() throws IndexOutOfBoundsException {
        for(int i = 1; i <= PARKING_SIZE; i++){
            if(!parking.containsKey(i)){
                return i;
            }
        }
//        for (Map.Entry<Integer, Car> finder : parking.entrySet()) {
//            if (finder.getValue() == null) {
//                return finder.getKey();
//            }
//
//        }
        return null;
    }

    public void print() {
        for (Map.Entry<Integer, Car> map : parking.entrySet()) {

            System.out.println(map.getKey() + " : " + map.getValue().getModel());

        }
    }
}
