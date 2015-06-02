package lection02.homework;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by storo_000 on 28.05.2015.
 */
public class Parking {
    private ArrayList<Car> parkingPlaces;

    public ArrayList<Car> getParkingPlaces() {
        return parkingPlaces;
    }

    public Parking() {
        parkingPlaces = new ArrayList<>(100);
        for (int i=0; i<100; i++)
            parkingPlaces.add(null);
    }

    public Parking(int places) {
        if (places > 0) {
            parkingPlaces = new ArrayList<>(places);
            for (int i=0; i<places; i++)
                parkingPlaces.add(null);
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


