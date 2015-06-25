package hw7.notes.service;

import hw7.notes.dao.CPUDaoImpl;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.dao.VendorDaoImpl;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Locale;

/**
 * Created by oleg on 24.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        NotebookServiceImpl service = new NotebookServiceImpl();
//        Notebook note = service.notebookDao.read(new Long(2));
        service.receive(new Long(8), 20, new Long(750));
        service.sale(new Long(2), 15);
    }
}
