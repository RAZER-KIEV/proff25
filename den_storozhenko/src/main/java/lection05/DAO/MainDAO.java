package lection05.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;
import java.util.Scanner;

/**
 * написать DAO Для регионов, CRUD, findAll
 * пользователь вводит имя региона, создаем, сохраняем, потом новое, изменяем
 *
 * добавить метод поиска региона по имени
 *
 * добавить метод получения регионов по диапазону ID
 *
 * вывести имена всех регионов порциями по 2 штуки
 */
public class MainDAO {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("lection05/dao.hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        RegionHibernateDaoImpl regionHibernateDao = new RegionHibernateDaoImpl(factory);

        /**
         * read
         *//*
        regionHibernateDao.read(2L).print();
        *//**
         * create
         *//*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of region:");
        Region region = new Region(scanner.nextLine());
        System.out.println(regionHibernateDao.create(region));
        *//**
         * update
         *//*
        System.out.println("Enter new name of region:");
        region.setName(scanner.nextLine());
        regionHibernateDao.update(region);
        *//**
         * findAll
         *//*
        for (Region concreteRegion:regionHibernateDao.findAll())
            concreteRegion.print();
        *//**
         * find(String name)
         *//*
        System.out.println("Enter name finding region:");
        for (Region concreteRegion:regionHibernateDao.find(scanner.nextLine()))
            concreteRegion.print();
        *//**
         * findID(Long startID, Long finishID)
         *//*
        System.out.println("Enter start and finish ID's:");
        for (Region concreteRegion:regionHibernateDao.findID(scanner.nextLong(), scanner.nextLong()))
            concreteRegion.print();*/
        /**
         * getNamesAllRegionsPorced()
         */
        Long count = regionHibernateDao.getCount();
        int step = 2;
        for (int i=0;i<count;i+=step){
            for (String str:regionHibernateDao.getNamesAllRegionsPorced(i,step)){
                System.out.println(str);
            }
        }
        factory.close();
    }
}