package hw7.springnotes.service;


import hw7.springnotes.dao.CPUDaoImpl;
import hw7.springnotes.dao.MemoryDaoImpl;
import hw7.springnotes.dao.NotebookDaoImpl;
import hw7.springnotes.dao.VendorDaoImpl;
import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Vendor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Locale;

/**
 * Created by Well on 03.07.2015.
 */
public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session12/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);


        NotebookDaoImpl ndi = new NotebookDaoImpl(factory);
        VendorDaoImpl vdi = new VendorDaoImpl(factory);
        vdi.create(new Vendor("Dell"));
        vdi.create(new Vendor("Intel"));

        CPUDaoImpl cdi = new CPUDaoImpl(factory);
        cdi.create(new CPU(vdi.read(2L), 2000L, "model145"));
        MemoryDaoImpl mdi = new MemoryDaoImpl(factory);
        mdi.create(new Memory(vdi.read(3L), 512L));



        ndi.create(new Notebook(vdi.read(1L), "Inspiria", new Date(),
                cdi.read(1L), mdi.read(1L)));

        factory.close();


    }
}
