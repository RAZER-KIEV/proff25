package homework2;

/**
 * Created by bosyi on 29.05.15.
 */
public class Parking {

    private Car[] cars;
    private final static int DEFAULT_CAPACITY = 6;
    private int capacity;
    private int occupied = 0;

    public Parking() {
        this(DEFAULT_CAPACITY);
    }

    public Parking(int capacity) {
        this.capacity = capacity;
        cars = new Car[capacity];
    }

    public boolean isFull() {
        return capacity == occupied ? true : false;
    }

    public int park(Car car) throws ParkFullException {
        if (isFull())
            throw new ParkFullException();
        int index = 0;
        while (cars[index] != null) {
            index++;
        }
        cars[index] = car;
        occupied++;
        return index;
    }

    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        if (placeNumber < 0 || placeNumber >= capacity || cars[placeNumber] == null) {
            throw new IndexOutOfBoundsException("" + placeNumber);
        }
        occupied--;
        Car car = cars[placeNumber];
        cars[placeNumber] = null;
        return car;
    }

}

class Car {

    private String number;
    private boolean isParked = false;

    public Car (String number) {
        this.number = number;
    }

}

class ParkFullException extends Exception {

    public ParkFullException() {
        super("it's full.. sorry");
    }

}
