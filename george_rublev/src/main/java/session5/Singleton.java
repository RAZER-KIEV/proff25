package session5;

/**
 * Created by george on 01.06.15.
 */
public class Singleton {

    private static Singleton singleton;
    Singleton(){}
    public static synchronized Singleton getSingleton(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
