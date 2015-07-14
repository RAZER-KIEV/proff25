package session5;

/**
 * Created by jul on 01.06.2015.
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
    public static synchronized Singleton getInstance (){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
