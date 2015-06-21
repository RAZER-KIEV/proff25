package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.Locale;

/**
 * Created by RAZER on 15.06.2015.
 */
@Entity
@Table(name = "Regions")

public class Region {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")
     private long id;

    @Column (name = "region_name")
    private String name;

    public Region(String regName){
        name = regName;
    }

    public Region() {
    }
}
