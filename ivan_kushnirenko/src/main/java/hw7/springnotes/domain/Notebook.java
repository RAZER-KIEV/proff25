package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    private Long id;
    private Vendor vendor;
    private String model;
    private Date manufDate;
    private CPU cpu;
    private Memory memory;

    public Notebook() {
        this(new Vendor(), "notebook", new Date(), new CPU(), new Memory());
    }

    public Notebook(Notebook notebook) {
        this.vendor = notebook.getVendor();
        this.model = notebook.getModel();
        this.manufDate = notebook.getManufDate();
        this.cpu = notebook.getCpu();
        this.memory = notebook.getMemory();
    }

    public Notebook(Vendor vendor, String model, Date manufDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufDate = manufDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Column(name = "notebook_model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "manufacture_date")
    @Temporal(TemporalType.DATE)
    public Date getManufDate() {
        return manufDate;
    }

    public void setManufDate(Date manufDate) {
        this.manufDate = manufDate;
    }

    @ManyToOne
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    @ManyToOne
    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return new String("NOTEBOOK id: " + id + ", vendor: " + vendor.getName() + ", model: " + model +
                ", manufacture date: " + manufDate + ", cpu: " + cpu.getModel() + ", memory: " + memory.getSize() + ".");
    }
}
