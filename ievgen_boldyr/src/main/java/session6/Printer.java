package session6;

/**
 * Created by IEvgen Boldyr on 02.06.15.
 * Project: proff25
 */

public final class Printer {

    private Printer() {}

    public static synchronized void print(String msg) throws InterruptedException {
        System.out.print("[ ");
        Thread.sleep(100);
        System.out.print(msg);
        Thread.sleep(100);
        System.out.println(" ]");
        Thread.sleep(100);
    }
}
