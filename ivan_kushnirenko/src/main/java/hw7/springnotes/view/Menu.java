package hw7.springnotes.view;


import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.NotebookService;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ivan on 06.07.15.
 */
public class Menu {

    private NotebookService notebookService;

    private Menu() {

    }

    public Menu(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    public NotebookService getNotebookService() {
        return notebookService;
    }

    public void setNotebookService(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    public void run() {
        System.out.println("##################################################################");
        System.out.println("###  Welcome to HIBERNATE DATA BASE CONSOLE PROGRAM by ivan !  ###");
        System.out.println("###      To start working, type command 'com' in console       ###");
        System.out.println("##################################################################");
        System.out.print("db_command: ");
        String command = "";
        Scanner scannerInput = new Scanner(System.in);
        do {
            command = scannerInput.nextLine();
            if (command.equals("exit")) {
                System.out.println("##################################################################");
                System.out.println("###      HIBERNATE DATA BASE CONSOLE PROGRAM by ivan .         ###");
                System.out.println("###                          goodbye!                          ###");
                System.out.println("##################################################################");
                return;
            }
            Scanner scannerCommand = new Scanner(command);
            if (command.matches("com")) {
                System.out.println("Command:    'com' - show all allowed commands; ");
                System.out.println("Command:    'exit' - close program;");
                System.out.println("Command:    'getNotebookByPortion' - get notebooks by portion, parameter: '-n' -size of portion;");
                System.out.println("Command:    'getNotebooksGtAmount' - get notebooks by amount more than parameter: '-p' - amount of notebooks; ");
                System.out.println("Command:    'getNotebooksByCpuVendor' -get notebooks by cpu vendor, parameter: '-s' - name of cpu vendor;");
                System.out.println("Command:    'getNotebooksFromStore' -get notebooks from store, without parameters;");
                System.out.println("Command:    'getNotebooksStorePresent' -get notebooks from store present, without parameters; ");
                System.out.println("Command:    'getSalesByDays' - shows sales by days, without parameters; ");
                System.out.println("Command:    'updateCPU' - updates CPU, parameters: '-i' - id, '-v' - cpu's vendor, '-f' - cpu's frequency, '-m' - cpu's model; ");
                System.out.println("Command:    'updateMemory' - updates memory, parameters: '-i' - id, '-v' - memory's vendor, '-s' - memory's size; ");
                System.out.println("Command:    'updateVendor' - updates vendor, parameters: '-i' - id, '-n' - vendor name; ");
            } else if (command.matches("getNotebookByPortion\\s[0-9]+")) {
                scannerCommand.next();
                System.out.println(notebookService.getNotebooksByPortion(Integer.parseInt(scannerCommand.next("[0-9]+"))));
            } else if (command.matches("getNotebooksGtAmount\\s[0-9]+")) {
                scannerCommand.next();
                System.out.println(notebookService.getNotebooksGtAmount(Integer.parseInt(scannerCommand.next("[0-9]+"))));
            } else if (command.matches("getNotebooksByCpuVendor\\s[A-Za-z]+")) {
                scannerCommand.next();
                Vendor vendor = new Vendor(scannerCommand.next());
                System.out.println(notebookService.getNotebooksByCpuVendor(vendor));
            } else if (command.matches("getNotebooksFromStore")) {
                System.out.println(notebookService.getNotebooksFromStore());
            } else if (command.matches("getNotebooksStorePresent")) {
                System.out.println(notebookService.getNotebooksStorePresent());
            } else if (command.matches("getSalesByDays")) {
                Map<Date, Double> sales = notebookService.getSalesByDays();
                for (Map.Entry entry : sales.entrySet()) {
                    System.out.println("Date " + entry.getKey() + ": " + entry.getValue() + " ;");
                }
            } else if (command.matches("updateCPU\\s[0-9]+\\s[A-Za-z]+\\s[0-9].[0-9]+\\s[A-Za-z]+")) {
                scannerCommand.next();
                CPU cpu = new CPU();
                cpu.setId(Long.valueOf(scannerCommand.next()));
                cpu.setProducer(scannerCommand.next());
                cpu.setFrequency(Double.parseDouble(scannerCommand.next()));
                cpu.setModel(scannerCommand.next());
                boolean result = notebookService.updateCPU(cpu);
                if (result == true) {
                    System.out.println(cpu + " has updated successfully.");
                } else {
                    System.out.println("ERROR: cannot update " + cpu);
                }
            } else if (command.matches("updateMemory\\s[0-9]+\\s[A-Za-z]+\\s[0-9]+")) {
                scannerCommand.next();
                Memory memory = new Memory();
                memory.setId(Long.valueOf(scannerCommand.next()));
                memory.setProducer(scannerCommand.next());
                memory.setSize(Integer.parseInt(scannerCommand.next()));
                boolean result = notebookService.updateMemory(memory);
                if (result == true) {
                    System.out.println(memory + " has updated successfully.");
                } else {
                    System.out.println("ERROR: cannot update " + memory);
                }
            } else if (command.matches("updateVendor\\s[0-9]+\\s[A-Za-z]+")) {
                scannerCommand.next();
                Vendor vendor = new Vendor();
                vendor.setId(Long.valueOf(scannerCommand.next()));
                vendor.setName(scannerCommand.next());
                boolean result = notebookService.updateVendor(vendor);
                if (result == true) {
                    System.out.println(vendor + " has updated successfully.");
                } else {
                    System.out.println("ERROR: cannot update " + vendor);
                }
            } else {
                System.out.println("ERROR: command '" + command + "' not found.");
                System.out.println("db_command: ");
                continue;
            }
            System.out.println("..................................................................");
            System.out.print("db_command: ");
        } while (true);
    }

    public static void main(String[] args) {

    }
}
