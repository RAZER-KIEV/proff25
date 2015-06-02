package lection03;

class Threads extends Thread{
    static Printer printer = new Printer();
}

class Thread1 extends Threads{

    @Override
    public void run() {
        try {
            for (int i=0;i<200;i++)
                printer.print(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Threads{

    @Override
    public void run() {
        try {
            for (int i=0;i<200;i++)
                printer.print(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Printer{
    public synchronized void print(String line) throws InterruptedException {
        System.out.print("[");
        Thread.sleep(1);
        System.out.print(line);
        Thread.sleep(1);
        System.out.println("]");
    }
}

public class ThreadsEx{
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();

    }
}

//2 потока 200 раз инфа о себе
