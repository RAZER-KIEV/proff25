package session5;

/**
 * Created by jul on 01.06.2015.
 */
public class FactoryEx {
    public static void main(String[] args) {
        Car auto = FactoryEx.getInstance ("Auto");
        Car truck = FactoryEx.getInstance ("Truck");
        Car ekskavator = FactoryEx.getInstance("Ekskavator");
    }
    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();
//    private static CreatorEkskavator creatorEkskavator = new CreatorEkskavator();

    public static Car getInstance (String type){
        if ("Auto".equals(type)){
            return creatorAuto.create();
        }
        if ("Truck".equals(type)){
            return creatorTruck.create();
        }
        return creatorAuto.create();
    }

    public static Car getInstance(String type, double volume){
        if ("Ekskavator".equals(type)){
            return new CreatorEkskavator(volume).create();
        }
        return getInstance(type);
    }

    private interface Creator{
        Car create();
    }
    private static class CreatorAuto implements Creator{
        @Override
        public Car create() {
            return new Auto();
        }
    }
    private static class CreatorTruck implements Creator{
        @Override
        public Car create() {
            return new Truck();
        }
    }
    private static class CreatorEkskavator implements Creator{
        private double volume;
        CreatorEkskavator (double volume){
            this.volume = volume;
        }
        @Override
        public Car create() {
            return new Ekskavator();
        }
    }
   static abstract class Car{

    }
    static class Auto extends Car{

    }
    static class Truck extends Car{

    }
    static class Ekskavator extends Car{
    private double volume;
    }
}
