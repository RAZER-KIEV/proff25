package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jax on 05.07.15.
 */
@Entity
@Table(name="notebook")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;
    @Column(name="VENDOR")
    private Vendor vendor;
    @Column(name="MODEL")
    private String model;
    @Column(name="DATE_CREATED")
    private Date date;
    @Column(name="CPU")
    private CPU cpu;
    @Column(name="MEMORY")
    private Memory memory;

    public Notebook(){

    }

    public Notebook(Vendor vendor,String model,Date date,CPU cpu,Memory memory){
        this.cpu=cpu;
        this.date=date;
        this.memory=memory;
        this.vendor=vendor;
        this.model=model;
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
}
