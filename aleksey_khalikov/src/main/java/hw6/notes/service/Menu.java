package hw6.notes.service;

import hw6.notes.domain.Notebook;
import java.util.List;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by GFalcon on 18.06.15.
 *Написать приложение для управления ноутбуками.
 Реализовать функции:
 - Добавить новый ноутбук
 - Показать список ноутбуков (включая порядковый номер id)
 *
 */
public class Menu {
    private static NotebookServiceImpl service = new NotebookServiceImpl();
    private static Notebook notebook;
    private static Scanner scan = new Scanner(System.in);
    private static boolean nextIteration;

    public static void main(String[] args){

        nextIteration = true;
        do {
            printConsoleMenu();
            int itemMenu = getIntegerFromeConsole();
            if(itemMenu < 0 || itemMenu > 2){
                System.out.println("Please input correct number of the menu item");
            } else {
                switch (itemMenu){
                    case (0): nextIteration = false; break;
                    case (1): addNewNotebook(); break;
                    case (2): printList(); break;
                }
            }
        } while (nextIteration);
    }

    public static void addNewNotebook(){
        System.out.println("Vendor:");
        String vendor = getStringFromConsole();
        System.out.println("Model:");
        String model = getStringFromConsole();
        System.out.println("Serial:");
        String serial = getStringFromConsole();
        System.out.println("Manufacture date:");
        Date manufactureDate = null;
        System.out.println("Price:");
        Double price = getDoubleFromConsole();

        notebook = new Notebook(serial, vendor, model, manufactureDate, price);

        service.add(notebook);

    }

    public static void printList(){
        List<Notebook> notList = service.findAll();
        System.out.println(notList.toArray().toString());
    }

    public static void printConsoleMenu(){
        System.out.println("Menu:");
        System.out.println("1. add new notebook;");
        System.out.println("2. print notebook list");
        System.out.println("0. exit");
        System.out.println();
        System.out.println("Enter the number of the menu item:");
    }

    public static String getStringFromConsole(){
        return scan.nextLine();
    }

    public static Double getDoubleFromConsole(){
        double value = 0.;
        nextIteration = true;
        do{
            if (scan.hasNextDouble()){
                value = scan.nextDouble();
                nextIteration = false;
            } else {
                System.out.println("please input Double value or word EXIT");
            }
            if (getStringFromConsole().equals("EXIT")) nextIteration = false;
        } while (nextIteration);
        return value;
    }

    public static Integer getIntegerFromeConsole(){
        int value = 0;
        nextIteration = true;
        do{
            if (scan.hasNextInt()){
                value = scan.nextInt();
                nextIteration = false;
            } else {
                System.out.println("please input Integer value or word EXIT");
            }
            if (getStringFromConsole().equals("EXIT")) nextIteration = false;
        } while (nextIteration);
        return value;
    }
}
