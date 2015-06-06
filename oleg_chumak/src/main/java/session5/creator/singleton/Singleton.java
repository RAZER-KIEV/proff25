package session5.creator.singleton;

/**
 * Created by oleg on 01.06.15.
 */
public class Singleton {

    private static Singleton instance;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
