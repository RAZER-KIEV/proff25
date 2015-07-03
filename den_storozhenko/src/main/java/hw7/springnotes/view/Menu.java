package hw7.springnotes.view;


import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.NotebookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private NotebookService notebookService;

    public Menu(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    public NotebookService getNotebookService() {
        return notebookService;
    }

    public void setNotebookService(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    public void updateVendorNotebook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter notebook id");
        Notebook notebook = notebookService.getNotebook(scanner.nextLong());
        System.out.println("Enter new Vendor id");
        notebook.setVendor(notebookService.getVendor(scanner.nextLong()));
        notebookService.updateNotebook(notebook);
    }

    public void updateVendorCPU(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CPU id");
        CPU cpu = notebookService.getCPU(scanner.nextLong());
        System.out.println("Enter new Vendor id");
        cpu.setVendor(notebookService.getVendor(scanner.nextLong()));
        notebookService.updateCPU(cpu);
    }

    public void updateVendorMemory(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter memory id");
        Memory memory = notebookService.getMemory(scanner.nextLong());
        System.out.println("Enter new Vendor id");
        memory.setVendor(notebookService.getVendor(scanner.nextLong()));
        notebookService.updateMemory(memory);
    }

    public void start(){
        System.out.println("Springnotes started.");
        String choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - working with Vendor\n2 - working with CPU\n3 - working with Memory\n" +
                "4 - working with Notebook\n5 - working with Store\n6 - working with Sales\ne - to exit\n");
        while (true) {
            choice = scanner.nextLine();
            switch (choice){
                case "1":{
                    System.out.println("1 - create Vendor\n2 - update Vendor");
                    choice = scanner.nextLine();
                    if(choice.equals("1")){
                        System.out.println("Enter name of new Vendor");
                        String name = scanner.nextLine();
                        notebookService.createVendor(new Vendor(name));
                    }
                    if(choice.equals("2")){
                        System.out.println("Enter id updated Vendor and new name");
                        Long id = scanner.nextLong();
                        String name = scanner.next();
                        Vendor vendor = notebookService.getVendor(id);
                        vendor.setName(name);
                        notebookService.updateVendor(vendor);
                    }
                    break;
                }
                case "2":{
                    System.out.println("1 - create CPU\n2 - update CPU");
                    choice = scanner.nextLine();
                    if(choice.equals("1")){
                        System.out.println("Enter id Vendor's, frequency and model");
                        Vendor vendor = notebookService.getVendor(scanner.nextLong());
                        Long frequency = scanner.nextLong();
                        String model = scanner.next();
                        notebookService.createCPU(new CPU(vendor, frequency, model));
                    }
                    if(choice.equals("2")){
                        System.out.println("Enter id updated CPU");
                        CPU cpu = notebookService.getCPU(scanner.nextLong());
                        while (true) {
                            System.out.println("1 - change Vendor\n2 - change frequency\n3 - change model\nelse - finish updating");
                            choice = scanner.next();
                            if (choice.startsWith("Hibernate:")){
                                choice = scanner.next();
                            }
                            if (choice.equals("1")){
                                System.out.println("Enter ID new Vendor's");
                                cpu.setVendor(notebookService.getVendor(scanner.nextLong()));
                            } else if (choice.equals("2")){
                                System.out.println("Enter new frequency");
                                cpu.setFrequency(scanner.nextLong());
                            } else if (choice.equals("3")) {
                                System.out.println("Enter new model");
                                cpu.setModel(scanner.next());
                            } else{
                                break;
                            }
                        }
                        notebookService.updateCPU(cpu);
                    }
                    break;
                }
                case "3":{
                    System.out.println("1 - create Memory\n2 - update Memory");
                    choice = scanner.nextLine();
                    if(choice.equals("1")){
                        System.out.println("Enter id Vendor's and size");
                        Vendor vendor = notebookService.getVendor(scanner.nextLong());
                        Long size = scanner.nextLong();
                        notebookService.createMemory(new Memory(size, vendor));
                    }
                    if(choice.equals("2")){
                        System.out.println("Enter id updated Memory");
                        Memory memory = notebookService.getMemory(scanner.nextLong());
                        while (true) {
                            System.out.println("1 - change Vendor\n2 - change size\nelse - finish updating");
                            choice = scanner.next();
                            if (choice.equals("1")){
                                System.out.println("Enter ID new Vendor's");
                                memory.setVendor(notebookService.getVendor(scanner.nextLong()));
                            } else if (choice.equals("2")){
                                System.out.println("Enter new size");
                                memory.setSize(scanner.nextLong());
                            } else{
                                break;
                            }
                        }
                        notebookService.updateMemory(memory);
                    }
                    break;
                }
                case "4":{
                    System.out.println("1 - create Notebook\n2 - update Notebook");
                    choice = scanner.next();
                    if(choice.equals("1")){
                        System.out.println("Enter id Vendor's, model, manufacture date(dd.MM.yyyy), CPU's id and Memory's id");
                        Vendor vendor = notebookService.getVendor(scanner.nextLong());
                        String model = scanner.next();
                        Date date = null;
                        try {
                            date = new SimpleDateFormat("dd.MM.yyyy").parse(scanner.next());
                        } catch (ParseException e) {
                            System.err.println("Uncorrect date format. Please enter date in format dd.MM.yyyy.");
                            try {
                                date = new SimpleDateFormat("dd.MM.yyyy").parse(scanner.next());
                            } catch (ParseException ex) {
                                System.err.println("Uncorrect date format!");
                                return;
                            }
                        }
                        CPU cpu = notebookService.getCPU(scanner.nextLong());
                        Memory memory = notebookService.getMemory(scanner.nextLong());
                        notebookService.createNotebook(new Notebook(vendor,model,date,cpu,memory));
                    }
                    if(choice.equals("2")){
                        System.out.println("Enter id updated Notebook");
                        Notebook notebook = notebookService.getNotebook(scanner.nextLong());
                        while (true) {
                            System.out.println("1 - change Vendor\n2 - change model\n3 - change manufacture date\n" +
                                    "4 - change cpu\n5 - change memory\nelse - finish updating");
                            choice = scanner.next();
                            if (choice.equals("1")){
                                System.out.println("Enter ID new Vendor's");
                                notebook.setVendor(notebookService.getVendor(scanner.nextLong()));
                            } else if (choice.equals("2")){
                                System.out.println("Enter new size");
                                notebook.setModel(scanner.next());
                            } else if (choice.equals("3")) {
                                System.out.println("Enter new manufacture date(dd.MM.yyyy)");
                                try {
                                    notebook.setManufactureDate(new SimpleDateFormat("dd.MM.yyyy").parse(scanner.next()));
                                } catch (ParseException e) {
                                    System.err.println("Uncorrect date format. Please enter date in format dd.MM.yyyy.");
                                    try {
                                        notebook.setManufactureDate(new SimpleDateFormat("dd.MM.yyyy").parse(scanner.next()));
                                    } catch (ParseException ex) {
                                        System.err.println("Uncorrect date format!");
                                        return;
                                    }
                                }
                            } else if (choice.equals("4")) {
                                System.out.println("Enter ID new CPU's");
                                notebook.setCpu(notebookService.getCPU(scanner.nextLong()));
                            } else if (choice.equals("5")) {
                                System.out.println("Enter ID new Memory");
                                notebook.setMemory(notebookService.getMemory(scanner.nextLong()));
                            } else{
                                break;
                            }
                        }
                        notebookService.updateNotebook(notebook);
                    }
                    break;
                }
                case "5":{
                    System.out.println("1 - receive to Store part Notebooks\n2 - remove from Store Notebooks\n3 - get Notebooks by portion\n" +
                            "4 - get Notebooks are more than a predetermined amount\n5 - get Notebooks to the specified name of the manufacturer of the processor\n" +
                            "6 - get all Notebooks on Store\n7 - get Notebooks, the remaining stock for each manufacturer");
                    choice = scanner.next();
                    switch(choice){
                        case "1":{
                            System.out.println("Enter Notebook id, amount and price");
                            System.out.println("Received Store id: "+notebookService.receive(scanner.nextLong(), scanner.nextInt(),scanner.nextDouble()));
                            break;
                        }
                        case "2":{
                            System.out.println("Enter Store id and amount Notebooks");
                            System.out.println(notebookService.removeFromStore(notebookService.getStore(scanner.nextLong()),scanner.nextInt()));
                            break;
                        }
                        case "3":{
                            System.out.println("Enter size of portion");
                            int i =1;
                            for(Notebook notebook:(List<Notebook>)notebookService.getNotebooksByPortion(scanner.nextInt())){
                                System.out.println("Portion "+i+++":");
                                notebook.print();
                            }
                            break;
                        }
                        case "4":{
                            System.out.println("Enter amount");
                            for (Notebook notebook:(List<Notebook>)notebookService.getNotebooksGtAmount(scanner.nextInt())){
                                notebook.print();
                            }
                            break;
                        }
                        case "5":{
                            System.out.println("Enter Vendor's id");
                            for(Notebook notebook:(List<Notebook>)notebookService.getNotebooksByCpuVendor(notebookService.getVendor(scanner.nextLong()))){
                                notebook.print();
                            }
                            break;
                        }
                        case "6":{
                            for (Notebook notebook:(List<Notebook>)notebookService.getNotebooksFromStore()){
                                notebook.print();
                            }
                            break;
                        }
                        case "7":{
                            Map<Vendor, List<Notebook>> map = notebookService.getNotebooksStorePresent1();
                            for (Map.Entry entry : map.entrySet()){
                                Vendor vendor = (Vendor) entry.getKey();
                                if (vendor==null) continue;
                                List<Notebook> notebookList = (List) entry.getValue();
                                vendor.print();
                                for (Notebook notebook1:notebookList){
                                    notebook1.print();
                                }
                                System.out.println();
                            }
                            break;
                        }
                    }
                    break;
                }
                case "6":{
                    System.out.println("1 - get Sales by days");
                    choice = scanner.next();
                    if (choice.equals("1")) {
                        Map<Date, Double> map = notebookService.getSalesByDays();
                        for (Map.Entry entry : map.entrySet()) {
                            System.out.println(entry.getKey() + " " + entry.getValue());
                        }
                    }

                    break;
                }
                case "e":{
                    return;
                }
                default:{
                    System.out.println("1 - working with Vendor\n2 - working with CPU\n3 - working with Memory\n" +
                            "4 - working with Notebook\n5 - working with Store\n6 - working with Sales\ne - to exit\n");
                    break;
                }
            }

        }
    }
}
