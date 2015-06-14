package session06;

/**
 * Синхронизированный вывод в консоль двумя потоками информации о себе. Метод Printer долден быть synchrinized
 * и каждый поток должен вызывать этот метод для ОДНОГО объекта. Этим достигается эффект, когда монитор
 * одиночного доступа не дает выполнятся второму потоку, если первый еще находится в синхронизированном методе.
 * И наоборот.
 * Created by Jeckgehor on 02.06.2015.
 */

public class PrinterTask {
    public static void main(String[] args) {
        Printer printer = new Printer();
        new PrintThread(printer).start();
        new PrintThread(printer).start();
    }

    static class PrintThread extends Thread {
        private Printer printer;

        public PrintThread (Printer printer) {
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