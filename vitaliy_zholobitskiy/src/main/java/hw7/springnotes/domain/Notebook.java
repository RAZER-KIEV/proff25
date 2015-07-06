package hw7.springnotes.domain;


import hw7.notes.domain.*;
import hw7.springnotes.domain.Notebook;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NOTEBOOKS_NEW")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NTBK_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private hw7.notes.domain.CPU cpu;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "MANUFACTURE_DATE")
    private Date manufacture_date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Memory memory;
    @OneToMany(mappedBy = "notebook",cascade = CascadeType.ALL)
    private Set<Store> storeSet = new HashSet<>();

    public Notebook(){
    }

    public Notebook( Vendor vendor, String model, Date manufacture_date, hw7.notes.domain.CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufacture_date =manufacture_date;
        this.cpu = cpu;
        this.memory = memory;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufactureDate(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public void setCpu(hw7.notes.domain.CPU cpu) {
        this.cpu = cpu;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }


    public Vendor getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public hw7.notes.domain.CPU getCpu() {
        return cpu;
    }

    public Memory getMemory() {
        return memory;
    }


    @Override
    public String toString(){
        return String.format("%s %s %s %s %s",vendor.toString(),model.toString(),manufacture_date.toString(),cpu.toString(),memory.toString());
    }

}
