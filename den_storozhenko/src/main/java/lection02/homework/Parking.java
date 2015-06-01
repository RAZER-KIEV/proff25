package lection02.homework;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by storo_000 on 28.05.2015.
 */
public class Parking {
    private ArrayList<Car> parkingPlaces;

    public Parking() {
        parkingPlaces = new ArrayList<>(100);
    }

    public Parking(int places) {
        if (places > 0) {
            parkingPlaces = new ArrayList<>(places);
        }
        else
            throw new IllegalArgumentException();
    }

    public int park(Car car1) throws ParkFullExeption {

        for (int i=0;i<parkingPlaces.size();i++)
            if (parkingPlaces.get(i)==null)
            {
                parkingPlaces.set(i,car1);
                return i;
            }
        throw  new ParkFullExeption();
    }

    public Car leave(int placeNumber){
        if (placeNumber>=parkingPlaces.size() || placeNumber<0)
            throw  new IndexOutOfBoundsException();
        return parkingPlaces.get(placeNumber);
    }
}

class ParkingTest{
    public static void main(String[] args) throws ParkFullExeption {
        Parking parking = new Parking(10);
        parking.park(new Car(2));
        parking.park(new Car(-1));
        parking.park(new Car(1));
        parking.leave(1);
    }
}

class Car{
    int number;

    public  Car(){
        number = new Random().nextInt();
    }

    public  Car(int n){
        number =n;
    }
}

class ParkFullExeption extends Exception{

}