package session5;

/**
 * Created by Sveta on 6/1/2015.
 */
public class FactoryEx {
    public static void main(String[] args) {
        Car excavator = FactoryEx.getInstance("Excavator");
        Car truck = FactoryEx.getInstance("Truck");

    }

    private static CreatorExcavator creatorExcavator = new CreatorExcavator();
    private static CreatorExcavator creatorTruck = new CreatorExcavator();

    public static Car getInstance(String type){
        if ("Excavator".equals(type)){
            return creatorExcavator.create();
        }
        if ("Truck".equals(type)){
            return creatorTruck.create();
        }
        return creatorTruck.create();
    }
   private interface Creator{
       Car create();
   }

    private static class CreatorExcavator implements Creator {

        double volume;
        @Override
        public Car create() {
            return new Excavator(volume);
        }
    }
    private static class CreatorTruck implements Creator {

        @Override
        public Car create() {
            return new Truck();
        }
    }

    abstract static class Car{

    }
    static class Excavator extends Car {
       private double volume;

        public Excavator(double volume) {
            this.volume = volume;
        }

    }
    static class Truck extends Car {

    }


}

