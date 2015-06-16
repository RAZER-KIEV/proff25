package hw2.hash.park;

import java.util.Map;
import java.util.TreeMap;

/**
 * Ќаписать класс представл€ющий парковку. — методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удал€емую машину
 ћетоды выбрасывают ислключени€ IndexOutOfBoundsException и ParkFullException
 Ќаписать модульный тест на класс Parking.
  лассы задани€:
 hw2.park.Parking
 hw2.park.Car
 * Created by rrudych on 27.05.15.
 */
public class Parking {

    private TreeMap<Integer, Car> map = new TreeMap<>();
    private Integer parkNum;
    private int sizeStatus;
    private int size;

    public Parking(Integer parkSize) {
        for(int i = 1; i<=parkSize; i ++) {
            map.put(i, null);
        }
        this.size = parkSize;
    }

    public int park(Car car) throws ParkFullException {
//        if(size==sizeStatus) {
//            throw new ParkFullException();
//        }
//        size++;
        Integer placeNumber = getEmptyPlaceNum();
        if(placeNumber == null)
            throw new ParkFullException();
        map.put(placeNumber, car);
        return placeNumber;
    }
    
    public Car leave (int placeNumber) {
        Car result = map.get(placeNumber);
        if(result == null) {
            throw new IndexOutOfBoundsException();
        }
        map.put(placeNumber, null);
        return result;
    }

    private Integer getEmptyPlaceNum() {
        for(Map.Entry<Integer,Car> set : map.entrySet()) {
            if(set.getValue() == null) {
                return set.getKey();
            }
        }
        return null;
    }
}

class ParkFullException extends Exception {

    public ParkFullException () {}

    public ParkFullException(String gripe) {
        super(gripe);
    }
}

class Car {
    private String number;

    public Car(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car Number: " + number;
    }
}

class ParkingTest {
    public static void main(String[] args) {
        Car car = new Car("AA7789DF");
        Car car2 = new Car("AA3454DF");
        Car car3 = new Car("AA2311DF");

        Parking park = new Parking(5);
        try {
            System.out.println(park.park(car));
            System.out.println(park.park(car2));
            System.out.println(park.park(car3));

            System.out.println(park.leave(2));
            System.out.println(park.park(car2));

        } catch (ParkFullException except) {
            except.printStackTrace();
        } catch (IndexOutOfBoundsException except) {
            except.printStackTrace();
        }
    }
}