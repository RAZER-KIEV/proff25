package session10;

import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by bosyi on 16.06.15.
 */
public class MainDao {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryDelivery.getSessionFactory();
        RegionHibernateDaoImpl worker = new RegionHibernateDaoImpl(sessionFactory);



        sessionFactory.close();
    }

    private static void printList(List<Region> regions) {
        for (Region region:regions) {
            System.out.println("ID: " + region.getId() + ",NAME: " + region.getRegionName() + ".");
        }
    }
}
