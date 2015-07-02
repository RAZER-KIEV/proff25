package hw7.notes.service;

import hw7.notes.HiberUtil.HiberUtil;
import hw7.notes.dao.*;
import hw7.notes.domain.*;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MainPoint {
    public static void main(String[] args) {
        HiberUtil hiberUtil= new HiberUtil();
        SessionFactory factory = hiberUtil.initialize();
        NotebookServiceImpl noteService = new NotebookServiceImpl(factory);
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        MemoryDaoImpl ramDao = new MemoryDaoImpl(factory);
        NotebookDaoImpl noteDao = new NotebookDaoImpl(factory);
      /*Vendor vendor1 = vendorDao.read(1L);
        Vendor vendor2 = vendorDao.read(2L);
        Vendor vendor3 = vendorDao.read(3L);
        Vendor vendor4 = vendorDao.read(4L);
        Vendor vendor5 = vendorDao.read(5L);
        Vendor vendor6 = vendorDao.read(6L);
        Vendor vendor7 = vendorDao.read(7L);
        Vendor vendor8 = vendorDao.read(8L);
        Vendor vendor9 = vendorDao.read(9L);
        Vendor vendor10 = vendorDao.read(10L);
        Vendor vendor11 = vendorDao.read(11L);
        Memory ram1= ramDao.read(1L);
        Memory ram2= ramDao.read(2L);
        Memory ram4= ramDao.read(3L);
        Memory ram8= ramDao.read(4L);
        Memory ram16= ramDao.read(5L);
        CPU i3 = cpuDao.read(1L);
        CPU i5 = cpuDao.read(2L);
        CPU i7 = cpuDao.read(3L);
        CPU a8 = cpuDao.read(4L);
        CPU a10 = cpuDao.read(5L);
        Notebook note1 = noteDao.read(1L);
        Notebook note2 = noteDao.read(2L);
        Notebook note3 = noteDao.read(3L);
        Notebook note4 = noteDao.read(4L);
        Notebook note5 = noteDao.read(5L);
        Notebook note6 = noteDao.read(6L);
        Notebook note7 = noteDao.read(7L);
        Notebook note8 = noteDao.read(8L);*/
        Map map;
        map = noteService.getNotebooksStorePresent();
        System.out.println(map);

        hiberUtil.factoryClose();
    }
}
