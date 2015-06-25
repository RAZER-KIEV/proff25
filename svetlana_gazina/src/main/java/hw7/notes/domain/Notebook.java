package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sveta on 6/25/2015.\
 * Тип ноутбука(производитель, модель, дата производства, процессор, память)
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private long id;
    @ManyToOne
    private Vendor vendor;
    private String model;
    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;
    @OneToOne
    private CPU cpu;
    @OneToOne
    private Memory memory;




}
