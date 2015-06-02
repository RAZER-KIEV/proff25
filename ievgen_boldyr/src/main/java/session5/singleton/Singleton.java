package session5.singleton;

/**
 * Created by IEvgen Boldyr on 01.06.15.
 * Project: proff25
 */

public class Singleton {

    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
