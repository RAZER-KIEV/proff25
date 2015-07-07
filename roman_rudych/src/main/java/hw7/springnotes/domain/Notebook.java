package hw7.springnotes.domain;

import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 25.06.2015.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @Column(name = "NOTEBOOK_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;

    @Column(name = "NOTEBOOK_MODEL")
    private String model;

    @Column(name = "MANUF_DATE")
    private Date manufactureDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CPU cpu;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Memory memory;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "notebookType", cascade = CascadeType.ALL)
    private Set<Store> store = new HashSet<>();

    public Notebook() {
    }

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
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

    public Set getStore() {
        return store;
    }

    public void setStore(Set store) {
        this.store = store;
    }

    public boolean equals(hw7.notes.domain.Notebook notebook) {
        return this.vendor.equals(notebook.getVendor()) && this.model.equalsIgnoreCase(notebook.getModel()) &&
                this.cpu.equals(notebook.getCpu()) && this.memory.equals(notebook.getMemory());
    }

    public String toString() {
        return "Vendor: " + vendor.getName() + ", Model: " + model +", CPU(MHz): " + cpu.getFreq() +", Memory(Gb): " + memory.getSize();
    }
}
