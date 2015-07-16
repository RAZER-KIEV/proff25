package hw7.notes;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Notebook;
import hw7.notes.service.NotebookService;
import hw7.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by bosyi on 30.06.15.
 */
public class MainTest {

    private static NotebookService service;

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        service = Main.generateService(factory);
        doNextWork();
        factory.close();
    }

    public static void doWork() {
        List<CPU> cpus = service.listAllCPUs();
        for(CPU cpu:cpus) {
            System.out.println("Vendor: " + cpu.getVendor() + ", CodeName: " + cpu.getCodeName() + ", Clock Rate: " + cpu.getClockRate());
        }
    }

    public static void doNextWork() {
        Notebook notebook = service.getNotebook(1L);
        System.out.println("*");
        System.out.println(notebook.getDateTime());
        System.out.println("*");
    }

}
