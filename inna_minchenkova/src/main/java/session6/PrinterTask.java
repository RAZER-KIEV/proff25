package session6;

/**
 * Created by Inna on 02.06.2015.
 */
//public class PrinterTask {
//    public static void main(String[] args) {
//        Printer printer = new Printer();
//        new PrintThread().start();
//        new PrintThread().start();
//    }
//
//    static class PrintThread extends Thread {
//        private Printer printer;
//
//        public PrintThread (Printer printer){
//
//        }
//
//        @Override
//        public void run() {
//            Printer printer = new Printer();
//            for (int i = 0; i < 200; i++) {
//                printer.print(getName());
//            }
//        }
//    }
//
//    static class Printer {
//        public synchronized void print(String line) {
//            try {
//                System.out.print('[');
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.print(line);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(']');
//
//            }
//            finally {
//
//            }
//        }
//
//    }
//}
