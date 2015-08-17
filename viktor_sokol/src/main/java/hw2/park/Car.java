package hw2.park;

/**
 * Created by Віктор on 6/7/2015.
 * Написать класс представляющий парковку. С методами:
 - int park(Car car) - поместить машину на парковку, возвращает номер паркоместа
 - Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
 Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

 Написать модульный тест на класс Parking.

 Классы задания:
 hw2.park.Parking
 hw2.park.Car
 */
public class Car {
    private int numberCar;
    private String model;

    public Car (int namberCar, String model){
        this.numberCar = namberCar;
        this.model = model;
    }

}
