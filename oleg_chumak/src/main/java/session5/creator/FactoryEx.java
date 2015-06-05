package session5.creator;

public class FactoryEx {
    public static void main(String[] args) {
        Car b = FactoryEx.getInstance("Auto");
        Car c = FactoryEx.getInstance("Truck");
        Car d = FactoryEx.getInstance("Excavator", 70);
        System.out.println(d);
    }

    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();


    public static Car getInstance(String type, int diggerCapacity) {
        if ("Auto".equals(type)) {
            return creatorAuto.create();
        }
        if ("Excavator".equals(type)) {
            return creatorAuto.create(diggerCapacity);
        }

        if ("Truck".equals(type)) {
            return creatorTruck.create();
        }
        return creatorAuto.create();
    }

    public static Car getInstance(String type){
        return getInstance(type, 0);
    }

    private interface Creator {
        Car create();
        default Car create(int capacity) {
            return null;
        }
    }

    private static class CreatorAuto implements Creator {
        @Override
        public Car create() {
            return new Auto();
        }
    }


    private static class CreatorExcavator implements Creator {
        int diggerCapacity;

        @Override
        public Car create() { return new Excavator(); }

        @Override
        public Car create(int capacity) {
            return new Excavator(capacity);
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

class Excavator extends Car {
    int diggerCapacity;

    public Excavator(int diggerCapacity) {
        this.diggerCapacity = diggerCapacity;
    }

    public Excavator() {
    }
}