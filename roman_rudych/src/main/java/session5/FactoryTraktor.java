package session5;

/**
 * Created by Роман on 01.06.2015.
 */
public class FactoryTraktor {


    public static Car getInstance(String type, int scoop) {
        if("Traktor".equalsIgnoreCase(type)) {
            return new CreatorTraktor(scoop).create();
        }
        return new CreatorTraktor(scoop).create();
    }
    public interface Creator {
        Car create();
    }

    private static class CreatorTraktor implements Creator {

        private int scoop;
        public CreatorTraktor(int scoop) {
            this.scoop = scoop;
        }
        @Override
        public Car create() {
            return new Traktor(scoop);
        }

    }
}
abstract class Car {

}

class Traktor extends Car{
    int scoop;
    public Traktor() {}

    public Traktor(int scoop) {

        this.scoop = scoop;
    }
}
