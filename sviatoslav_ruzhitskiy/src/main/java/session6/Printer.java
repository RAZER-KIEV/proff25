package session6;

/**
 * Created by RAZER on 02.06.2015.
 */
public class Printer {
       synchronized public void  prints(String str){

        try {
            System.out.print("[");
            Thread.sleep(1);
            System.out.print(str);
            Thread.sleep(1);
            System.out.println("]");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

class ThreadCreator extends Thread{
    Printer prt;

    public ThreadCreator(Printer prt){
        this.prt=prt;

    }
    @Override
    public void run(){
        for(int i = 0; i<200;i++ ){
        prt.prints(String.valueOf(Thread.currentThread()));
        }
    }
}
class PrintUser {
    public static void main(String[] args) {
        Printer prt = new Printer();
        ThreadCreator threadCreator1 = new ThreadCreator(prt);
        threadCreator1.start();
        ThreadCreator threadCretor2 = new ThreadCreator(prt);
        threadCretor2.start();
    }
}