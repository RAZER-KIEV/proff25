package hw2;

import java.util.HashMap;
import java.util.Map;

/**Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину

 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car
 * Created by lukashevich.e on 28.05.2015.
 */
public class Parking {

    private HashMap<Integer, Car> baseParking;
    int seats;

    Parking (){
        this(10);
    }

    Parking (int seats) {
        this.seats = seats;
        baseParking = new HashMap<Integer, Car>();
        for (int i = 1; i <= seats; i++){
            baseParking.put(i, null);
        }
    }

    public static void main (String[] args) throws Exception {

        Parking parking = new Parking();
        Car car1 = new Car("BMW", 11111, "red");
        Car car2 = new Car("Audi", 21548, "green");
        Car car3 = new Car("MAN", 96301, "yellow");
        Car car4 = new Car("Doc", 87463, "black");
        Car car5 = new Car("Reno", 89214, "blue");
        parking.park(car1);
        parking.park(car2);
        parking.park(car3);
        parking.park(car4);
        parking.park(car5);
        System.out.println(parking);
        System.out.println(parking.leave(2));
        System.out.println(parking);
        Car car6 = new Car("Toren", 45897, "dark");
        parking.park(car6);
        System.out.println(parking);
    }

    public int park(Car car) throws ParkFullException {
        // Поместить машину на парковку, возвращает номер паркоместа
        if (baseParking.containsValue(null)) {
            for(Map.Entry<Integer, Car> item : baseParking.entrySet()){
                if(item.getValue() == null) {
                    baseParking.put(item.getKey(), car);
                    return item.getKey();
                }
            }
        }
        throw new ParkFullException("Park full");
    }


    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        // Удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
        if (placeNumber <= 0 || placeNumber > seats) {
            throw new IndexOutOfBoundsException("Error number place");
        }
        Car car = null;
        for(Map.Entry<Integer, Car> item : baseParking.entrySet()){
            if(item.getKey() == placeNumber){
                if (item.getValue() != null) {
                    car = item.getValue();
                    baseParking.put(item.getKey(), null);
                } else {
                    throw new IndexOutOfBoundsException("No car in place " + item.getKey());
                }
            }
        }
        return car;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Car> item : baseParking.entrySet()){
            if (item.getValue()!= null) {
                sb.append("Place:" + item.getKey()+ ", car: " + item.getValue().toString() + "|| ");
            } else {
                sb.append("Place:" + item.getKey()+ ", car: " + "null" + "|| ");
            }
        }
        return sb.toString();
    }

    class ParkFullException extends Exception {
        ParkFullException () {
        }

        ParkFullException (String msg) {
            super(msg);
        }
    }

    class IndexOutOfBoundsException extends Exception {
        IndexOutOfBoundsException () {
        }

        IndexOutOfBoundsException (String msg) {
            super(msg);
        }
    }
}

class Car {

    String model;
    int number;
    String color;

    Car () {
        this.model = "Unknown";
        this.number = 0;
        this.color = "Unknown";
    }

    Car (String model, int number, String color) {
        this.model = model;
        this.number = number;
        this.color = color;
    }

    @Override
    public String toString(){
        return model + ", " + number + ", " + color;
    }
}

class ParkingTest {

}
