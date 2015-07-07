package hw7.notes.domain;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Inna on 27.06.2015.
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MANUFACTURE_DATE")
    private Date manufactureDate;

    @ManyToOne
    private CPU cpu;

    @ManyToOne
    private Memory memory;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "notebook")
    @Fetch(FetchMode.SELECT)
    private Set<Store> storeSet;

    public Notebook(){

    }

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Store> getStoreSet() {
        return storeSet;
    }

    public void setStoreSet(Set<Store> storeSet) {
        this.storeSet = storeSet;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", cpu=" + cpu +
                ", memory=" + memory +
                '}';
    }
}
