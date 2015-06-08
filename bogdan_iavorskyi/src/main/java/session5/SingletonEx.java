package session5;

/**
 * Created by bosyi on 01.06.15.
 */
public class SingletonEx {

    private static SingletonEx instance;

    private SingletonEx() {

    }

    public static synchronized SingletonEx getInstance() {
        if (instance == null) {
            instance = new SingletonEx();
        }
        return instance;
    }

}
