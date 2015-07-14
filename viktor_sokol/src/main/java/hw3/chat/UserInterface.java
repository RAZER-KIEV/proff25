package hw3.chat;

import java.net.ConnectException;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {
    public Set<DatabaseUnit> database = DatabaseUnit.loadUnits();
    Scanner scanner=null;
    public UserInterface(){
        help();
    }

    public void help(){
        System.out.println("Для добавления контакта в адресную книгу введите команду:  add, логин абонента, IP, все через пробел.");
        System.out.println("Для удаления контакта из адресной книги введите команду: delete и логин абонента через пробел.");
        System.out.println("Для окрытия диалога с абонентом введите команду: connect и логин абонента через пробел, "
                + "далее нажмите Enter, введите сообщение и нажмите Enter.");
        System.out.println("Для выхода из режима диалог введите команду: disconnect.");
        System.out.println("Для просмотра списка абонентов введите команду: showAll.");
        System.out.println("Для вызова справки по командам программы введите команду: help.");
        System.out.println("Для выхода из программы введите команду: quit.");
    }

    //добавляем пользователя в БД
    public void add(String login, String IP){
        DatabaseUnit unit = new DatabaseUnit(login,IP);
        database.add(unit);
        unit.saveUnit();
    }

    //удаление контакта
    public void delete(String login){
        for(DatabaseUnit unit : database)
            if(unit.login.equals(login)){
                unit.deleteUnit();    //удаляем файл абонента из папки физически
                database.remove(unit);  //удаляем контакт в БД
            }
            else System.out.println("No such login.");
    }

    //просмотр контактов в БД
    public void showAll(){
        for(DatabaseUnit unit : database)
            System.out.println(unit.login+" "+unit.IP);
    }

    //сохранение компонентов БД
    public void saveDatabase(){
        for(DatabaseUnit unit : database)
            unit.saveUnit();
    }

    //для выхода из программы
    public void quit(){
        scanner.close();
        System.exit(0);
    }

    //для подключения к абоненту
    public void connect(String login){
        boolean checkPoint=false;    ////  my remark
        for(DatabaseUnit unit : database){
            if(unit.login.equals(login)){
                checkPoint=true;     ////  my remark
                //try {
                Connection connection = new Connection(unit.IP);
                if (connection.socket!=null){
                    while(true){
                        String text = scanner.nextLine();
                        if(text.equals("disconnect")){
                            disconnect();
                            break;
                        }
                        else
                            connection.sendMessage(unit.IP, text);
                    }
                }
            } else continue;      //my remark
        }
        if (!checkPoint) System.out.println("No such login...Fuck!");  ////  my remark
        if(database.isEmpty())
            System.out.println("DataBase is empty");
    }

    //для отключения от абонента
    public void disconnect(){
        System.out.println("Connection is interrapted.");
    }

    //метод для работы пользователя с интерфейсом
    public void start(){
        Server server = new Server(); //слушаем порт
        scanner = new Scanner(System.in);
        String operation, login, ip;
        while(true){
            operation = scanner.nextLine();
            String[] operationsAndLogins=operation.split(" "); //разбиваем на массив строк для вычлинения команды и логина
            if (operationsAndLogins.length<=1){
                operation=operationsAndLogins[0];
                switch (operation) {
                    case "showAll":
                        showAll();
                        break;
                    case "help":
                        help();
                        break;
                    case "quit":
                        server.interrupt(); //оставливаем работу сервера
                        quit();
                        break;
                    case "disconnect":
                        System.out.println("No connection available.");
                        break;
                    default:
                        System.out.println("Wrong command.");
                        break;
                }
            }
            else if(operationsAndLogins.length==2){
                operation=operationsAndLogins[0];
                login=operationsAndLogins[1];
                switch (operation) {
                    case "delete":
                        delete(login);
                        break;
                    case "connect":
                        connect(login);
                        break;
                    default:
                        System.out.println("Wrong command.");
                        break;
                }
            }
            else if(operationsAndLogins.length==3){
                operation=operationsAndLogins[0];
                login=operationsAndLogins[1];
                ip=operationsAndLogins[2];
                switch (operation) {
                    case "add":
                        add(login, ip);
                        break;
                    default:
                        System.out.println("Wrong command.");
                        break;
                }
            }
            else System.out.println("Wrong command.");

        }


    }

}