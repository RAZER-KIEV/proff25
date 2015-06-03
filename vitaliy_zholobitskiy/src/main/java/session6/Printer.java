package session6;

class PrinterTask {
    static Printer  printer = new Printer();
    public static void main(String[] args) {
        new FirstThread().start();
        new SecondThread().start();
    }

    static class FirstThread extends Thread {

        @Override
        public void run() {

            for (int i = 0; i < 200; i++) {
                printer.print(getName());
            }
        }
    }
    static class SecondThread extends Thread {

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
                Thread.sleep(1000);
                System.out.print(line);
                Thread.sleep(1000);
                System.out.println(']');
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}