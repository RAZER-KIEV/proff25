package Homework2.Park;

import java.util.HashMap;

/**
 * Created by Sveta on 5/29/2015.
 * Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру паркоместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car
 */
public class Parking {
    private int capacity;
    private int cars;

    public HashMap<Integer, Car> getCarsSet() {
        return carsSet;
    }

    public void setCarsSet(HashMap<Integer, Car> carsSet) {
        this.carsSet = carsSet;
    }

    private HashMap<Integer, Car> carsSet = new HashMap<>();

    public Parking (int capasity){
        this.capacity = capasity;
    }

    public int park (Car car) throws ParkFullException {
        int place = 1;

        if(cars >= capacity){
            throw new ParkFullException();
        }
        while(carsSet.containsKey(place)){
            place++;
        }
        carsSet.put(place, car);
        cars++;
        return place;
    }

    public Car leave(int placeNumber){
        Car car = null;
        if(placeNumber <= 0 ||  placeNumber > capacity){
            throw new IndexOutOfBoundsException();
        }
        car = carsSet.get(placeNumber);
        carsSet.remove(placeNumber);
        cars--;
        return car;
    }

}
class ParkFullException extends Exception
{
    public ParkFullException() {}

    public ParkFullException(String message)
    {
        super(message);
    }
}
class Car {
    private String model;
    private String colour;
    private int number;


    public Car(){

    }
    public Car(String model, int number){
        this.model = model;
        this.number = number;
    }
    public Car(String model, String colour, int number){
        this(model, number);
        this.colour = colour;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumber() {

        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.getModel() + ": " + this.getNumber();
    }
}
class ParkingTest {
    public static void main(String[] args) throws ParkFullException {
        Parking parking = new Parking(5);

        System.out.println(parking.park(new Car("BMW", 123453)));
        System.out.println(parking.park(new Car("HONDA", 785590)));
        System.out.println(parking.park(new Car("OPEL", 978453)));
        System.out.println(parking.park(new Car("OPEL", 457433)));
        System.out.println(parking.park(new Car("SUZUKI", 869472)));

        System.out.println(parking.leave(3));
        System.out.println(parking.park(new Car("OPEL", 950384)));

        //parking.park(new Car());
        // parking.leave(9);





    }


}
