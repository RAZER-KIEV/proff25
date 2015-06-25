package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Sveta on 6/25/2015.
 */
@Entity
@Table(name = "VENDORS")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDORS_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "VENDORS_ID")
    private long id;
    private String name;
}
