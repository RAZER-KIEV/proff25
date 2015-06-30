package hw7.notes.domain;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Set;

/**
 * Created by viktoria
 * Project:.hw7
 * Создать сущности для базы данных "Магазин ноутбуков":
 * Тип ноутбука(производитель, модель, дата производства, процессор, память)
 */

@Entity
@Table(name = "NOTEBOOK")
public class Notebook {

    @Id
    @SequenceGenerator(name= "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;

    @Column (name = "MODEL")
    private String model;

    @Column (name = "MANUFACTURE_DATE")
    private GregorianCalendar manufactureDate;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CPU cpu;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Memory memory;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "notebook")
    private Set<Store> stores;

    public Notebook(){

    }

    public Notebook (Vendor vendor, String model, GregorianCalendar manufactureDate, CPU cpu, Memory memory){
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.cpu = cpu;
        this.memory = memory;
    }

    @Override
    public String toString(){
        return "Notebook: \n" + vendor + "\n" + model + "\n" + manufactureDate + "\n" + cpu + "\n" + memory + "\n" ;
    }


    public Long getId() {
        return id;
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

    public GregorianCalendar getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(GregorianCalendar manufactureDate) {
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
}
