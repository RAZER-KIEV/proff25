package hw7.notes.view;

import hw7.notes.domain.Vendor;
import hw7.notes.service.NotebookServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * Created by GFalcon on 25.06.15.
 *
 * Создать приложение магазин ноутбуков со следующими функциями:
 Создать процессор
 Создать память
 Создать производителя
 Создать тип ноутбука
 Принять на склад партию ноутбуков (тип ноутбука, количество, цена)
 Продать указанное количество ноутбуков со склада(id склада, количество)
 */
public class Menu {
    private static NotebookServiceImpl service = new NotebookServiceImpl();

    public static void main(String[] args){
        viewMainMenu();
    }

    public static void viewMainMenu(){
        boolean nextIteration = true;
        while (nextIteration){
            System.out.println("Menu:");
            System.out.println("1. Create CPU");
            System.out.println("2. Create memory");
            System.out.println("3. Create vendor");
            System.out.println("4. Create noutbook");
            System.out.println("5. To take to the warehouse party laptops");
            System.out.println("6. To sell a specified number of laptops from stock");
            System.out.println("7. Edit database...");
            System.out.println("8. Generate reports...");
            System.out.println("0. exit");
            System.out.println();
            System.out.println("Enter the number of the menu item:");
            int itemMenu = getIntegerFromConsole();
            if(itemMenu < 0 || itemMenu > 6){
                System.out.println("Please input correct number of the menu item");
            } else {
                switch (itemMenu){
                    case (0):
                        System.out.println("I'll be back >:-[");
                        nextIteration = false; break;
                    case (1): createCPU(); break;
                    case (2): createMemory(); break;
                    case (3): createVendor(); break;
                    case (4): createNoutbook(); break;
                    case (5): receiveStore(); break;
                    case (6): saleFromStore(); break;
                    case (7): viewEditMenu(); break;
                    case (8): viewReportsMenu(); break;
                }
            }
            printSeparator();
        }
    }

    public static void viewEditMenu() {
        boolean nextIteration = true;
        while (nextIteration) {
            System.out.println("1. Update CPU");
            System.out.println("2. Update Memory");
            System.out.println("3. Update Vendor");
            System.out.println("4. Update Notebook");
            System.out.println("5. Remove Notebooks from store");
            System.out.println("0. Go back to main menu");
            System.out.println();
            System.out.println("Enter the number of the menu item:");
            int itemMenu = getIntegerFromConsole();
            if (itemMenu < 0 || itemMenu > 5) {
                System.out.println("Please input correct number of the menu item");
            } else {
                switch (itemMenu) {
                    case (0):
                        System.out.println("I'll be back >:-[");
                        nextIteration = false;
                        break;
                    case (1):
                        updateCPU();
                        break;
                    case (2):
                        updateMemory();
                        break;
                    case (3):
                        updateVendor();
                        break;
                    case (4):
                        updateNotebook();
                        break;
                    case (5):
                        removeFromStore();
                        break;
                }
            }
            printSeparator();
        }
    }

    public static void viewReportsMenu(){
        boolean nextIteration = true;
        while (nextIteration) {
            System.out.println("1. Show all laptops in stock (the user specifies the size of the portions)");
            System.out.println("2. Show all laptops are greater than a specified amount");
            System.out.println("3. Show all laptops with the specified name of the manufacturer of the processor.");
            System.out.println("4. Show all laptops in stock.");
            System.out.println("5. Show the types of laptops remaining in stock for each manufacturer.");
            System.out.println("6. To receive the sales volume of notebook computers on an average day.");
            System.out.println("0. Go back to main menu");
            System.out.println();
            System.out.println("Enter the number of the menu item:");
            int itemMenu = getIntegerFromConsole();
            if (itemMenu < 0 || itemMenu > 6) {
                System.out.println("Please input correct number of the menu item");
            } else {
                switch (itemMenu) {
                    case (0):
                        System.out.println("I'll be back >:-[");
                        nextIteration = false;
                        break;
                    case (1):
                        getNotebooksByPortion();
                        break;
                    case (2):
                        getNotebooksGtAmount();
                        break;
                    case (3):
                        getNotebooksByCpuVendor();
                        break;
                    case (4):
                        getNotebooksFromStore();
                        break;
                    case (5):
                        getNotebooksStorePresent();
                        break;
                    case (6):
                        getSalesByDays();
                        break;
                }
            }
            printSeparator();
        }
    }

    public static void printSeparator(){
        System.out.println();
        System.out.println("====================================================");
        System.out.println();
    }

    public static void createCPU(){
        System.out.println("Enter ID from vendors list:");
        //   printVedorList();
        long vendorId = getLongFromConsole();

    }

    public static void createMemory(){

    }

    public static void createVendor(){
        System.out.println("Enter vendor name:");
        String name = getStringFromConsole();
        Vendor vendor = new Vendor(name);
        service.createVendor(vendor);
    }

    public static void createNoutbook(){

    }

    public static void receiveStore(){

    }

    public static void saleFromStore(){

    }

    public static void updateCPU(){

    }

    public static void updateMemory(){

    }

    public static void updateVendor(){

    }

    public static void updateNotebook(){

    }

    public static void removeFromStore(){

    }

    public static void getNotebooksByPortion(){

    }

    public static void getNotebooksGtAmount(){

    }

    public static void getNotebooksByCpuVendor(){

    }

    public static void getNotebooksFromStore(){

    }

    public static void getNotebooksStorePresent(){

    }

    public static void getSalesByDays(){

    }

    private static String getStringFromConsole(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static Double getDoubleFromConsole(){
        double volume = 0;
        do {
            Scanner vol = new Scanner(System.in);
            if (vol.hasNextDouble()) {
                volume = vol.nextDouble();
                break;
            } else {
                System.out.println("please input Double value");
            }
        } while (true);
        return volume;
    }

    private static Integer getIntegerFromConsole(){
        int volume = 0;
        do {
            Scanner vol = new Scanner(System.in);
            if (vol.hasNextInt()) {
                volume = vol.nextInt();
                break;
            } else {
                System.out.println("please input Integer value");
            }
        } while (true);
        return volume;
    }

    private static Long getLongFromConsole(){
        long volume = 0;
        do {
            Scanner vol = new Scanner(System.in);
            if (vol.hasNextLong()) {
                volume = vol.nextLong();
                break;
            } else {
                System.out.println("please input Long value");
            }
        } while (true);
        return volume;
    }

    public static void printVedorList(){
        System.out.println("Vendors:");
        List<Vendor> vendors = service.getVendorsList();
        for (int i = 0; i < vendors.size(); i++){
            System.out.println(vendors.get(i).toString());
        }
    }

}
