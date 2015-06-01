package session5;

public class FactoryEx {
    public static void main(String[] args) {
        Car b = FactoryEx.getInstance("B");
        Car c = FactoryEx.getInstance("C");
        Car digger = FactoryEx.getInstance("Digger",150);
    }

    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();
    private static CreatorDigger creatorDigger = new CreatorDigger();

    public static Car getInstance(String type) {
        if ("Auto".equals(type)) {
            return creatorAuto.create();
        }
        if ("Truck".equals(type)) {
            return creatorTruck.create();
        }
        if ("Digger".equals(type)) {
            return creatorTruck.create();
        }
        return creatorAuto.create();
    }

    public static Car getInstance(String type, double bucketCapacity) {
        if ("Digger".equals(type)) {
            creatorDigger.setBucket(bucketCapacity);
            return creatorDigger.create();
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

    private static class CreatorDigger implements Creator {

        private double bucket;

        public CreatorDigger() {
            this(100.2);
        }

        public CreatorDigger(double bucket) {
            this.bucket = bucket;
        }

        public void setBucket(double bucket) {
            this.bucket = bucket;
        }

        @Override
        public Car create() {
            return new Digger(bucket);
        }
    }


}


abstract class Car {

}

class Auto extends Car {

}

class Truck extends Car {

}

class Digger extends Car {

    private double bucket;

    public Digger(double bucket) {
        this.bucket = bucket;
    }

}