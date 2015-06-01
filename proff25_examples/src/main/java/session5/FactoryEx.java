package session5;

public class FactoryEx {
    public static void main(String[] args) {
        Car b = FactoryEx.getInstance("Auto");
        Car c = FactoryEx.getInstance("Excavator", 200);
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

    public static Car getInstance(String type, double volume) {
        if ("Excavator".equals(type)) {
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

        public CreatorExcavator(double volume) {
            this.volume = volume;
        }

        @Override
        public Car create() {
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