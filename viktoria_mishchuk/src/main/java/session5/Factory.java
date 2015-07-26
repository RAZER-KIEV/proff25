package session5;

/**
 * Created by viktoria
 * Project:.session5
 */
public class Factory {
    public static void main(String[] args) {
        Car b = Factory.getInstance(CarType.Auto);
        Car c = Factory.getInstance(CarType.Truck);
        Car a = Factory.getInstance(CarType.Excavator, 200.00);
    }

    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();
//    private static CreatorExcavator creatorExcavator= new CreatorExcavator();

    public static Car getInstance(CarType type) {
        if (CarType.Auto == type) {
            return creatorAuto.create();
        }
        if (CarType.Truck == type) {
            return creatorTruck.create();
        }

        return creatorAuto.create();
    }

    public static Car getInstance(CarType type, double volume) {
        if (CarType.Excavator == type) {
            return new CreatorExcavator(volume).create();
        }
        return getInstance(type);
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

    private static class CreatorExcavator implements Creator {
        private double volume;


        public  CreatorExcavator(double volume){
            this.volume = volume;
            
        }

        @Override
        public  Car create(){
            return new Excavator(volume);
        }
    }


}


abstract class Car {

}

class Auto extends Car {

}

class Truck extends Car {

}

class Excavator extends Car {
    private double volume;

    public Excavator(double volume) {
        this.volume = volume;
    }
}