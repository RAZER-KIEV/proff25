package nw7.notes.domain;

import javax.persistence.*;
import java.util.Locale;

/**
 * Created by ПК on 25.06.2015.
 */

@Entity
@Table(name = "VENDORS" )

public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDORS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private String name;

    public Vendor(){}
    public Vendor(String name){
        this.name=name;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
