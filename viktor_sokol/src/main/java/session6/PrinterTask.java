package session6;

/**
 * Created by Віктор on 6/2/2015.
 */
public class PrinterTask {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new PrintThread(printer).start();
        new PrintThread(printer).start();
        new PrintThread(printer).start();
    }

    static class PrintThread extends Thread {
        public Printer printer;

        public PrintThread(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            Printer printer = new Printer();
            for (int i = 0; i < 200; i++) {
                printer.print(getName());
            }
        }
    }

    static class Printer {
        public synchronized void print(String line) {
            try {
                System.out.print('[');
                Thread.sleep(1);
                System.out.print(line);
                Thread.sleep(1);
                System.out.println(']');
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}