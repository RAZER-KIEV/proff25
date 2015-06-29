package session5;

/**
 * Created by Віктор on 6/1/2015.
 */

public class FactoryEx {
//    public static void main(String[] args) {
//        Car auto = FactoryEx.getInstance(TypesEnum.AUTO);
//        Car truck = FactoryEx.getInstance(TypesEnum.TRUCK);
//        Car excavator = FactoryEx.getInstance(TypesEnum.EXCAVATOR);
//    }
//
//    private static CreatorAuto creatorAuto = new CreatorAuto();
//    private static CreatorTruck creatorTruck = new CreatorTruck();
//    private static CreatorExcavator creatorExcavator = new CreatorExcavator();
//
//    public static Car getInstance(TypesEnum type) {
//        if (TypesEnum.AUTO == type) {
//            return creatorAuto.create();
//        }
//        if (TypesEnum.TRUCK == type) {
//            return creatorTruck.create();
//        }
//        if (TypesEnum.EXCAVATOR == type) {
//            return creatorExcavator.create();
//        }
//        return creatorAuto.create();
//    }

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

        @Override
        public Car create() {
            return new Excavator();
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
}