package session4.hw3;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by oleg on 27.05.15.
 */
public class Parking {
    private int size;
    private int onParking;
    TreeMap<Integer, Car> parking = new TreeMap<>();
    private static final int DEFAULT_CAPACITY = 10;

    public Parking() {
        this(DEFAULT_CAPACITY);
    }

    public Parking(int capacity){
        size = capacity;
        for(int i = 1; i <= capacity; i++){
            parking.put(i, null);
        }
    }

    public int park(Car car) throws ParkFullException {
        if (size == onParking){
            throw new ParkFullException();
        }
        else {
            int index = findEmptyPlace();
            parking.put(index, car);
            onParking++;
            return  index;
        }
    }

    public Car leave(int placeNumber){
        if(placeNumber < 1 | placeNumber > size){
            throw new IndexOutOfBoundsException();
        }
        else {
            Car tmp = parking.get(placeNumber);
            if(tmp == null){
                throw new IndexOutOfBoundsException();
            }
            else {
                parking.put(placeNumber, null);
                onParking--;
                return tmp;
            }
        }
    }

    private int findEmptyPlace() throws ParkFullException {
        for(int i = 1; i <=size; i++ ){
            if(parking.get(i) == null) return i;
        }
        throw new ParkFullException();
    }

}

class Car{
    private String governmentalNumber;

    public Car(String governmentalNumber) {
        this.governmentalNumber = governmentalNumber;
    }

    public Car() {}

    @Override
    public String toString(){
        return governmentalNumber;
    }
}
class ParkFullException extends Exception{

    @Override
    public String toString(){
        return "Parking is full";
    }
}

class ParkingTest{}
//
//class Main{
//    public static void main(String[] args) throws ParkFullException {
//        Parking park = new Parking(5);
//        Car car = new Car("V");
//        Car car1 = new Car("S");
//        Car car2= new Car("a");
//        Car car3 = new Car("tt");
//        Car car4 = new Car("ddd");
//        Car car5 = new Car("asdd");
//        System.out.println(park.add(car));
//        System.out.println(park.add(car1));
//        System.out.println(park.add(car2));
//        System.out.println(park.add(car3));
//        System.out.println(park.add(car4));
//        System.out.println(park.leave(2));
//        System.out.println(park.leave(1));
//        System.out.println(park.add(car5));
//    }
//}