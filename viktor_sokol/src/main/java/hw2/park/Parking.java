package hw2.park;

import java.util.ArrayList;

/**
 * Created by Віктор on 6/7/2015.
 *Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car
 */
public class Parking {
    private int placeNumber;
    private int capacity = 10;
    private Car car;
    private ArrayList<Car>  parking;


    public Parking(){
        this.placeNumber = placeNumber;
        this.car = car;
        this.capacity = capacity;
        this.parking = parking;
        parking = new ArrayList<>(capacity);
        for(int i=0;i<capacity;i++){
            parking.add(null);
        }
    }

    public int park (Car car) throws ParkFullException{
        if(placeNumber >= capacity)
            throw new ParkFullException();
        placeNumber = getFreePlaceNumber();
        parking.add(placeNumber,car);
        return placeNumber;
    }

    public Car leave (int placeNumber){
        if((placeNumber<0)|| (placeNumber >= capacity)) throw new IndexOutOfBoundsException();
        Car car= parking.get(placeNumber);
        parking.add(placeNumber,null);
        return car;
    }

    int getFreePlaceNumber(){
        for(int i=0;i<parking.size();i++){
            if (parking.get(i)==null)
                return i;
        }
        return 0;
        }
    }


    class ParkFullException extends Exception {

        public ParkFullException() {
            System.out.print("Parking is full");
        }


}

class ParkingTest{
    public void test() throws ParkFullException {
        Parking parking1= new Parking();
        Car car1= new Car(12,"zaz");
        Car car2= new Car(15,"bmw");
        Car car3= new Car(56,"audi");

        System.out.println(parking1.park(car1));
        System.out.println(parking1.park(car2));
        System.out.println(parking1.park(car3));
        System.out.print(parking1.leave(2));

    }

    public static void main(String[] args) throws ParkFullException{
        ParkingTest parkingTest = new ParkingTest();
        parkingTest.test();
    }
}




