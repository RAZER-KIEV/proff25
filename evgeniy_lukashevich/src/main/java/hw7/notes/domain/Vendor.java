package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    public Vendor () {
    }

    public Vendor (String name) {
        this.name = name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName (){
        return this.name;
    }
}
