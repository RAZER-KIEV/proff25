package Homework2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by just1ce on 29.05.2015.
 */
public class Parking {
    int capacity;
    int placeUsed;
    ArrayList<Car> park;
    public Parking() {
        capacity=15;
        placeUsed=0;
        park = new ArrayList<>(15);
        for(int i=0;i<15;i++){
            park.add(null);
        }
    }
    public Parking(int capacity){
        this.capacity=capacity;
        placeUsed=0;
        park = new ArrayList<>(capacity);
        for(int i=0;i<capacity;i++){
            park.add(null);
        }
    }
    public int park(Car car) throws ParkFullException {
        if(capacity==placeUsed) throw new ParkFullException();
        int place=getNumberOfFreePlace();
        park.add(place,car);
        placeUsed++;
        return  place+1;
    }
    Car leave(int placeNumber){
        if((placeNumber-1<0)|| (placeNumber-1>capacity)) throw new IndexOutOfBoundsException();
        Car car= park.get(placeNumber-1);
        park.add(placeNumber-1,null);
        return car;

    }
    int getNumberOfFreePlace(){
        for(int i=0;i<park.size();i++){
            if (park.get(i)==null)
                return i;
        }
        return 0;

    }
}
class ParkFullException extends Exception{

    @Override
    public String toString(){
        return "No empty space!";
    }
}
class ParkingTest{
    public void test() throws ParkFullException {
        Parking parking= new Parking();
        Car car1= new Car(123,"mazda");
        Car car2= new Car(465,"toyota");
        Car car3= new Car(846565,"BMW");
        Car car4= new Car(8565,"Mersedes");
        System.out.println(parking.park(car1));
        System.out.println(parking.park(car2));
        System.out.println(parking.park(car3));
        System.out.println(parking.leave(3));
        System.out.println(parking.park(car4));
        System.out.println(parking.leave(3));
        System.out.println(parking.leave(3));
    }
}
class Car{
    int number;
    String model;
    Car(int n,String m){
        this.number=n;
        this.model=m;
    }
    @Override
    public String toString(){
        return model;
    }
}
