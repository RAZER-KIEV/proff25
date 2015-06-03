package session6;

/**
 * Created by IEvgen Boldyr on 02.06.15.
 * Project: proff25
 * Создать класс Printer
 * print(String msg) - строчка которую мы выводим. (Формат: [ msg ]);
 *
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    try {
                        Printer.print(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        for (int i = 0; i < 200; i++) {
            try {
                Printer.print(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
