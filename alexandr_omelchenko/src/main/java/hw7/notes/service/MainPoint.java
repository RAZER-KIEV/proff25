package hw7.notes.service;

import hw7.notes.HiberUtil.HiberUtil;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * Created by HP on 26.06.2015.
 */
public class MainPoint {
    public static void main(String[] args) {
        HiberUtil hiberUtil= new HiberUtil();
        SessionFactory factory = hiberUtil.initialize();
        NotebookServiceImpl noteService = new NotebookServiceImpl(factory);
        Vendor vendor = new Vendor("Hewlett-Packard");
        CPU cpu = new CPU(3L, "i5", vendor);
        Memory ram= new Memory(4L, vendor);
        Notebook nBook = new Notebook("1017nr",new Date(), vendor, cpu, ram);
        vendor.addNoteBook(nBook);
        cpu.addNoteBook(nBook);
        ram.addNoteBook(nBook);
        vendor.addCpu(cpu);
        vendor.addRam(ram);
noteService.updateNotebook(nBook);
        noteService.updateCPU(cpu);
        noteService.updateMemory(ram);
        noteService.updateVendor(vendor);
        Store store = new Store();
        Sales sales = new Sales();
        noteService.create(nBook);
        hiberUtil.factoryClose();
    }
}
