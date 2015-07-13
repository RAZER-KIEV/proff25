package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by george on 26.06.15.
 */
@Entity
@Table(name = "NOTEBOOK")
public class Notebook {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "model")
    private String model;

    @Column(name = "date_manufacture")
    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    @ManyToOne
    private CPU cpu;

    @ManyToOne
    private Memory memory;

    public Notebook(Vendor vendor, String model, Date manufactureDate, CPU cpu, Memory memory) {
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    public Notebook() {
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

    public void print(){
        System.out.print("Notebook: "+id+" "+vendor.getName()+" "+model+" "+
                manufactureDate.getYear()+"/"+manufactureDate.getMonth()+"/"+manufactureDate.getDay()+" ");
        cpu.print();
        memory.print();
        System.out.println();
    }
}
