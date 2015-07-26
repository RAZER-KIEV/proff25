package session6;

/**
 * Created by viktoria
 * Project:.session6
 */
public class PrinterThreads {


    public static void main(String[] args) {
        Printer printer = new Printer();
        new PrinterThread(printer).start();
        new PrinterThread(printer).start();


    }

    static class PrinterThread extends Thread {
        private Printer printer;

        public PrinterThread (Printer printer){
            this.printer = printer;

        }

        @Override
        public void run() {

            for (int i = 0; i < 200; i++) {
                printer.print(getName());
            }


        }
    }

    static class Printer {

        public  synchronized void print(String line) {
            try {
                System.out.print("[");
                Thread.sleep(10);
                System.out.print(line);
                Thread.sleep(10);
                System.out.println("]");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}