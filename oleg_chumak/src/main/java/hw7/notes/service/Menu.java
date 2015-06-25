package hw7.notes.service;

import hw7.notes.dao.CPUDaoImpl;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Vendor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by oleg on 24.06.15.
 */
public class Menu {
    public static void main(String[] args) {
        Long a = new Long(2);
        Long b = new Long (3);
        if (a > b){
            System.out.println("aaa");
        }
        else {
            System.out.println("bbb");
        }
    }
}
