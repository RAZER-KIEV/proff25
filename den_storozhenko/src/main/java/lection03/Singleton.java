package lection03;

/**
 * Created by Taras on 01.06.2015.
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton(){
    }

    public static  synchronized Singleton getInstance(){
        if (singleton==null)
            singleton=new Singleton();
        return  singleton;
    }
}
