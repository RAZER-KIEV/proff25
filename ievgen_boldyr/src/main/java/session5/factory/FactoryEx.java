package session5.factory;

public class FactoryEx {
    public static void main(String[] args) {
        Car auto = FactoryEx.getInstance(TypesEnum.AUTO);
        Car truck = FactoryEx.getInstance(TypesEnum.TRUCK);
        Car excavator = FactoryEx.getInstance(TypesEnum.EXCAVATOR);
        Car excVol = FactoryEx.getInstance(TypesEnum.EXCAVATOR, VolumeEnum.MEDIUM);
    }

    private static CreatorAuto creatorAuto = new CreatorAuto();
    private static CreatorTruck creatorTruck = new CreatorTruck();
    private static CreatorExcavator creatorExcavator = new CreatorExcavator();

    public static Car getInstance(TypesEnum type) {
        if (TypesEnum.AUTO == type) {
            return creatorAuto.create();
        }
        if (TypesEnum.TRUCK == type) {
            return creatorTruck.create();
        }
        if (TypesEnum.EXCAVATOR == type) {
            return creatorExcavator.create();
        }
        return creatorAuto.create();
    }

    public static Car getInstance(TypesEnum type, VolumeEnum volume) {
        if (TypesEnum.EXCAVATOR == type) {
            Car car = creatorExcavator.create();
            Excavator excavator = (Excavator) car;
            excavator.setVolume(volume);
            return (Car) excavator;
        }
        return creatorExcavator.create();
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
    private VolumeEnum volume;

    public Excavator(){}

    public VolumeEnum getVolume() {
        return volume;
    }

    public void setVolume(VolumeEnum volume) {
        this.volume = volume;
    }
}