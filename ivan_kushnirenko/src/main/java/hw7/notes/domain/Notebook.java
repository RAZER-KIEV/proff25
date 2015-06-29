package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name="NOTEBOOK")
public class Notebook {
/*
Тип ноутбука:
    -производитeель,
    -модель,
    -дата производства,
    -процессор,
    -память.
 */

    private Long id;
    private Vendor vendor;
    private String model;
    private Date manufDate;
    private CPU cpu;
    private Memory memory;
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="VENDOR")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    @Column
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Column
    public Date getManufDate() {
        return manufDate;
    }

    public void setManufDate(Date manufDate) {
        this.manufDate = manufDate;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="CPU")
    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="MEMORY")
    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    @Override
    public String toString(){
        return new String("NOTEBOOK id: "+id+", vendor: "+vendor.getName()+", model: "+model+
        ", manufacture date: "+manufDate+", cpu: "+cpu.getModel()+", memory: "+memory.getSize()+".");
    }
}
