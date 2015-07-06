package hw7.springnotes.service;

import java.util.Scanner;

public class Menu {
    private NotebookService service;
    public Menu() {
    }
    public Menu(NotebookService service) {
        this.service=service;
    }

    public NotebookService getService() {
        return service;
    }
    public void setService(NotebookService service) {
        this.service = service;
    }

    private static String [] actions =
{"1.getNotebooksByPortion", "2.getNotebooksGtAmount", "3.getNotebooksByCpuVendor",
        "4.getNotebooksFromStore", "5.getNotebooksStorePresent","6.getSalesByDays", "0.Exit" };
    public void printMenu(){
        for(String s: actions){
        System.out.println(s);}
    }
    public void openMenu(){
        Scanner scanner =new Scanner(System.in);
        boolean runwhile=true;
        while(runwhile){
            printMenu();
            System.out.println("Choice operation:");
            int k = scanner.nextInt();
            switch (k){
                case 1: f1()   ;break;
                case 2: f2()   ;break;
                case 3: f3()   ;break;
                case 4: f4()   ;break;
                case 5: f5()   ;break;
                case 6: f6()   ;break;
                case 0:runwhile = false;
            }
        }
    }
    public void f1(){
    System.out.println("Enter portion size");
    Scanner scan = new Scanner(System.in);
    int portion = scan.nextInt();
    System.out.println(service.getNotebooksByPortion(portion));
}
    public void f2(){
        System.out.println("Enter count of notebooks which more than");
        Scanner scan = new Scanner(System.in);
        int kol = scan.nextInt();
        System.out.println(service.getNotebooksGtAmount(kol));
    }
    public void f3(){
        System.out.println("Enter Vendor id");
        Scanner scan = new Scanner(System.in);
        Long id = scan.nextLong();
        System.out.println(service.getNotebooksByCpuVendor(service.readVendor(id)));
    }
    public void f4(){
System.out.println(service.getNotebooksFromStore());
    }
    public void f5(){
        System.out.println(service.getNotebooksFromStore());
    }
    public void f6(){
        System.out.println(service.getSalesByDays());
    }
}