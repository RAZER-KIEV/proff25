package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by oleg on 24.06.15.
 * Тип ноутбука(производитель, модель, дата производства, процессор, память)
 */

@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private CPU cpu;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Memory memory;

    public Notebook(Vendor vendor, String model, Date date, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.date = date;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Notebook() {
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", model='" + model + '\'' +
                ", date=" + date +
                ", cpu=" + cpu +
                ", memory=" + memory +
                '}';
    }
}
