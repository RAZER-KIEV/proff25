package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Sveta on 6/25/2015.
 * (производитель, размер)
 */
@Entity
@Table(name = "MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORIES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MEMORIES_ID")
    private long id;
    @ManyToOne
    private Vendor vendor;
    private Integer capacity;
}
