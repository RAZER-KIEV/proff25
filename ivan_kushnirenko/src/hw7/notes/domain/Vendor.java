package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {
    /*
    Производители:
     -имя.
     */

    private Long id;
    private String name;
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return new String("VENDOR id is: "+id+", name is: "+name+".");
    }
}
