package week3_lesson5;

public class Singleton {
    private static Singleton instance;
    private Singleton(){
    }
    public static synchronized Singleton getInstance(){
        if(instance==null)            {
            instance=new Singleton(); }
        return instance;
    }
    public static void main(String[] args) {
        Singleton st1 = new Singleton();
        Singleton st2 = new Singleton();
        System.out.println(st1.getInstance().equals(st2.getInstance()));
                                           }
}