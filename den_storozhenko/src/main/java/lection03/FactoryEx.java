package lection03;

enum TypeCar{
    AUTO, TRUCK, Excavator
};

public class FactoryEx {
    public static void main(String[] args) {
        Car b = FactoryEx.getInstance(TypeCar.AUTO);
        Car c = FactoryEx.getInstance(TypeCar.Excavator, 29);
    }

    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();
    private static CreatorExcavator creatorExcavator = new CreatorExcavator();

    public static Car getInstance(TypeCar type) {
        if (type==TypeCar.AUTO) {
            return creatorAuto.create();
        }
        if (type==TypeCar.TRUCK) {
            return creatorTruck.create();
        }
        if (type==TypeCar.Excavator){
            return creatorExcavator.create();
        }
        throw new IllegalArgumentException();
    }

    public static Car getInstance(TypeCar type, double val) {
        if (type==TypeCar.AUTO) {
            return creatorAuto.create();
        }
        if (type==TypeCar.TRUCK) {
            return creatorTruck.create();
        }
        if (type==TypeCar.Excavator){
            return creatorExcavator.create(val);
        }
        throw new IllegalArgumentException();
    }

    private interface Creator {
        Car create();
    }

    private static class CreatorAuto implements Creator {
        @Override
        public Car create() {
            return new Auto();
        }
    }

    private static class CreatorTruck implements Creator {
        @Override
        public Car create() {
            return new Truck();
        }
    }
    private static class CreatorExcavator implements Creator{
        @Override
        public Car create() {
            return new Excavator();
        }
        public Car create(double val){
            return new Excavator(val);
        }
    }
}


abstract class Car {

}

class Auto extends Car {

}

class Truck extends Car {

}

class Excavator extends Car{
    public double volume;
    public Excavator(){}
    public Excavator(double vol){
        volume=vol;
    }
}