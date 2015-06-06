package session6.thread;

/**
 * Created by oleg on 02.06.15.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
//
        Printer p = new Printer();
//        for (int i = 0; i < 200; i++) {
//            p.print(Thread.currentThread().getName());
//        }
        Thread anotherThread = new Thread(new MyRunnable(p));
        Thread newThread = new Thread(new MyRunnable(p));
        anotherThread.start();
        newThread.start();
    }

    static class MyRunnable implements Runnable {
        Printer printer  = new Printer();

        public MyRunnable() {
        }

        public MyRunnable(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                try {
                    printer.print(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Printer {

    public synchronized void print(String str) throws InterruptedException {
        System.out.print("[ ");
        Thread.sleep(10);
        System.out.print(str);
        Thread.sleep(10);
        System.out.println(" ]");
    }
}