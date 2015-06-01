package homeTasks.week2;

import java.util.HashMap;

/**
 Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Написать модульный тест на класс Parking.
 Классы задания:
 hw2.park.Parking
 hw2.park.Car
 */
public class Parking {
    private HashMap<Integer, Car> parking = new HashMap<>();
    private int[] park = new int[100];
    private int num;
    public int park(Car car) throws ParkFullException {
        for (int pl : park) {
            if (pl == 0) {
                parking.putIfAbsent(pl, car);
                return pl;
            }
        }
        throw new ParkFullException("На парковке нет свободных мест");
    }
    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        if (parking.containsKey(placeNumber)) {
            Car car = parking.remove(placeNumber);
            return car;
        } else throw new IndexOutOfBoundsException("Нет места с таким номером");
    }

    public class Car {
        String number;

        @Override
        public boolean equals(Object obj) {
            Car car = (Car) obj;
            if (this.number == car.number)
                return true;
            else return false;
        }
        @Override
        public int hashCode() {
            return number.hashCode();
        }
    }
    public class ParkFullException extends Exception {
        public ParkFullException(String message) {
            super(message);                }
        @Override
        public String getMessage() {
         return super.getMessage();}
    }

}