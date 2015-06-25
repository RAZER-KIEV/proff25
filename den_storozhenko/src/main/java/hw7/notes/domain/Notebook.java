package hw7.notes.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NOTEBOOKS_2")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS2_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;
    @ManyToOne
    private Vendor vendor;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "MANUFACT_DATE")
    @Temporal(TemporalType.DATE)
    private Date manufactureDate;
    @ManyToOne
    private CPU cpu;
    @ManyToOne
    private Memory memory;
    @OneToMany(mappedBy = "notebook",cascade = CascadeType.ALL)
    private Set<Store> storeSet = new HashSet<>();

    public Notebook(){
    }

    public Notebook(Long id, Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public CPU getCpu() {
        return cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void print(){
        System.out.print("Notebook: "+id+" "+vendor.getName()+" "+model+" "+
                manufactureDate.getYear()+"/"+manufactureDate.getMonth()+"/"+manufactureDate.getDay()+" ");
        cpu.print();
        memory.print();
        System.out.println();
    }
}