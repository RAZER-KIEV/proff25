package main.hw2.park;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by george on 28.05.15.
 */
public class Parking {

    int placeNumber;
    int maxNum = 10;

    Map<Integer, Car> carTreeMap = new HashMap<>();

    Parking(int maxNum){

        this.maxNum = maxNum;
//        for (int i = 0; i<maxNum;i++){
//            carTreeMap.put(i,null);
//        }
    }

    public int park(Car car) throws ParkFullException {

        int num = 0;
        do{
            if(num<maxNum){

                if(carTreeMap.get(num)==null) {
                    carTreeMap.put(num, car);
                }else{
                    num++;
                }

            }else{
                throw new ParkFullException();
            }

        }
        while(carTreeMap.get(num)!=null);

        return --num;
    }


    class ParkFullException extends Exception {

        public ParkFullException () {}

        public ParkFullException(String gripe) {
            super(gripe);
        }
    }

    public Car leave(int placeNamber){

        Car tmp = carTreeMap.get(placeNamber);
        if(tmp == null) {
            throw new IndexOutOfBoundsException();
        }
        carTreeMap.remove(placeNamber);
        //вернуть данные с карточки авто
        return tmp;
    }

    public int getSize(){
        return carTreeMap.size();
    }



}
/**
 * Created by george on 28.05.15.
 */
class Car {
    private String model;
    private String numberCar;

    public Car(String model, String numberCar){
        this.model = model;
        this.numberCar = numberCar;
    }

    public String getModel(){
        return model;
    }
    public String getNumberCar(){
        return numberCar;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setNumberCar(String numberCar){
        this.numberCar = numberCar;
    }
    @Override
    public String toString() {
        return "Car Number: " + numberCar + "  "+model;
    }

}

class ParkingTest{
    public static void main(String[] args) {

        Car c1 = new Car("KIA", "AA0000AA");
        Parking parking = new Parking(10);

        int tc1 = 0;
        try {
            tc1 = parking.park(c1);
        } catch (Parking.ParkFullException e) {
            System.out.println("Park is full.");
        }


        System.out.println(tc1);
        System.out.println(parking.leave(tc1));
    }
}
