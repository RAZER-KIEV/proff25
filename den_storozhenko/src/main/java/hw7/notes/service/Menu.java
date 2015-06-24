package hw7.notes.service;


import hw7.notes.HibernateUtil;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.hibernate.SessionFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Menu {
    public static void main(String[] args) throws ParseException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();
        SessionFactory sessionFactory = hibernateUtil.getFactory();

        NotebookServiceImpl notebookService = new NotebookServiceImpl(sessionFactory);
        notebookService.createDao();



        Vendor vendor = new Vendor("Dell");
        notebookService.createVendor(vendor);
        CPU cpu = new CPU(250000L, "AMD");
        notebookService.createCPU(cpu);
        Memory memory = new Memory(4000L, "NVIDIA");
        notebookService.createMemory(memory);
        Notebook notebook = new Notebook(vendor, "N5010", new SimpleDateFormat("dd.MM.yyyy").parse("20.06.2010"), cpu, memory);
        notebookService.createNotebook(notebook);

        for(Notebook notebook1:notebookService.getNotebooksByPortion(8)) {
            notebook1.print();
        }
        System.out.println();

        System.out.println(notebookService.receive(notebook, 5, 15600.));
        System.out.println(notebookService.sale(2L, 2));




        sessionFactory.close();
    }
}
