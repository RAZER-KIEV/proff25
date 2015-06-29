package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
@Entity
@Table(name = "Notebook")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOK_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    private Vendor vendor;
    @Column (name = "MODEL")
    private String model;
    @Column (name = "MANUF_DATE")
    private Date manufactureDate;
    @ManyToOne
    private CPU cpu;
    @ManyToOne
    private Memory memory;

    public Notebook () {

    }

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public void setVendor (Vendor vendor) {
        this.vendor = vendor;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public void setManufactureDate (Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setCpu (CPU cpu) {
        this.cpu = cpu;
    }

    public void setMemory (Memory memory) {
        this.memory = memory;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public String getModel () {
        return this.model;
    }

    public Date getManufactureDate() {
        return this.manufactureDate;
    }

    public CPU getCpu () {
        return this.cpu;
    }

    public Memory getMemory () {
        return this.memory;
    }
}
