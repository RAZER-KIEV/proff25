package hw7.notes.domain;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by GFalcon on 24.06.15.
 *
 * Тип ноутбука(производитель, модель, дата производства, процессор, память)
 */
@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @Id
    @SequenceGenerator(name = "myseq", sequenceName = "SEQ_NOTEBOOK", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @Column(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "DATE")
    private Date manufactureDate;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @Column(name = "CPU")
    private CPU cpu;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @Column(name = "MEMORY")
    private Memory memory;

    @OneToMany(mappedBy = "notebook",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private Set<Store> storeSet;

    public Notebook(){
        storeSet = new HashSet<Store>();
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", vendor=" + vendor.toString() +
                ", model='" + model.toString() + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", cpu=" + cpu.toString() +
                ", memory=" + memory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(id, notebook.id) &&
                Objects.equals(vendor, notebook.vendor) &&
                Objects.equals(model, notebook.model) &&
                Objects.equals(manufactureDate, notebook.manufactureDate) &&
                Objects.equals(cpu, notebook.cpu) &&
                Objects.equals(memory, notebook.memory) &&
                Objects.equals(storeSet, notebook.storeSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendor, model, manufactureDate, cpu, memory, storeSet);
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

    public void addStore(Store store){
        this.storeSet.add(store);
    }
}
