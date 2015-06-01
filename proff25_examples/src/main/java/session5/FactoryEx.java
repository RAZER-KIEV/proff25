package session5;

public class FactoryEx {
    public static void main(String[] args) {
        Car b = FactoryEx.getInstance("B");
        Car c = FactoryEx.getInstance("C");
    }

    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();

    public static Car getInstance(String type) {
        if ("Auto".equals(type)) {
            return creatorAuto.create();
        }
        if ("Truck".equals(type)) {
            return creatorTruck.create();
        }
        return creatorAuto.create();
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


}


abstract class Car {

}

class Auto extends Car {

}

class Truck extends Car {

}