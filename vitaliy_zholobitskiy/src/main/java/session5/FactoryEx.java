package session5;

/**
 * Created by just1ce on 01.06.2015.
 */
public class FactoryEx {
   /*public static void main(String[] args) {
        Car auto = FactoryEx.getInstance("Auto",0);
        Car truck = FactoryEx.getInstance("Truck",0);
        Car ex = FactoryEx.getInstance("Ex",20);
    }*/

    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();
    private static CreatorEx creatorEx = new CreatorEx();

    public static Car getInstance(String type,int value) {
        if ("Auto".equals(type)) {
            return creatorAuto.create();
        }
        if ("Truck".equals(type)) {
            return creatorTruck.create();
        }
        if ("Ex".equals(type)) {
            if (value==0) return creatorEx.createW(value);
            return creatorEx.create();
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
    private static class CreatorEx implements Creator {
        @Override
        public Car create() {
            return new Ex();
        }
        public Car createW(int value){
            return null;
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
class Ex extends Car {

}