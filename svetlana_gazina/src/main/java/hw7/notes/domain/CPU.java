package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Sveta on 6/25/2015.
 * Процессоры(производитель, частота, модель)
 */
@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CPU_ID")
    private long id;
    @ManyToOne
    private Vendor vendor;
    private String model;
    @Column(name = "CLOCK_RATE")
    private Integer clockRate;
}
