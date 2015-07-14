package hw3.chat;

public class Main {

    public static void main(String[] args) {
        final UserInterface UI = new UserInterface();
        Runtime.getRuntime().addShutdownHook(new Thread(){   //для сохранения всех изминений в базе данных
            public void run(){
                UI.saveDatabase();
            }
        });
        UI.start();

    }
}
