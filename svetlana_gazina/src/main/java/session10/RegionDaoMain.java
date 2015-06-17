package session10;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Sveta on 6/16/2015.
 */
public class RegionDaoMain {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        Scanner scanner = new Scanner(System.in);
        RegionHibernateDaoImpl hibernateDao = new RegionHibernateDaoImpl(factory);



//        System.out.println("Enter region:");
//        String regionString = scanner.nextLine();
//        Region region = new Region(regionString);
//
//        Long crt = hibernateDao.create(region);

//        List<Region> regions = hibernateDao.findByIdRange((long)5, (long)8);
//        System.out.println(regions.get(0).getName());

//        List<Region> regions = hibernateDao.findByName("Asia");
//        System.out.println(regions);

        List<Region[]> regions = hibernateDao.findByPortions(1, 3);
        for (Region[] list: regions){
            System.out.println(list);
        }


    }
}
