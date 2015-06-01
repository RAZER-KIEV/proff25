package hw2.park;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Написать класс представляющий парковку. С методами:
 * - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 * - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 * Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException
 * <p>
 * Написать модульный тест на класс Parking.
 * <p>
 * Классы задания:
 * hw2.park.Parking
 * hw2.park.Car.
 */
public class Parking {

    private Map<Integer, Car> parking;


    public Parking(){
        parking = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            parking.put(i,null);
        }
    }


    public int park(Car car) throws ParkFullException {
        for (Integer i : parking.keySet()) {
            if (parking.get(i) == null) {
                car.setPlaceNumber(i);
                parking.put(i,car);
                return car.getPlaceNumber();
            }
        }
        throw new ParkFullException("НеПолучилосьException;)");
    }

    public Car leave(int placeNumber) {
        Set<Integer> places = parking.keySet();
       if (places.contains(placeNumber)) {
           Car leaveCar = parking.get(placeNumber);
           leaveCar.setPlaceNumber(null);
           parking.put(placeNumber, null);
           return leaveCar;
       } else {
           throw new IndexOutOfBoundsException();
       }
    }
}
