package session6;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 23.02.15
 */
public class PrinterTask {
    public static void main(String[] args) {
        new PrintThread().start();
        new PrintThread().start();
    }

    static class PrintThread extends Thread {

        @Override
        public void run() {
            Printer printer = new Printer();
            for (int i = 0; i < 200; i++) {
                printer.print(getName());
            }
        }
    }

    static class Printer {
        public void print(String line) {
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
