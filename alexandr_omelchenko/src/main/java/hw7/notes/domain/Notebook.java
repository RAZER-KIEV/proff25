package hw7.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 1. Создать сущности для базы данных "Магазин ноутбуков":
 Тип ноутбука(производитель, модель, дата производства, процессор, память)
 Производители(имя)
 Процессоры(производитель, частота, модель)
 Память(производитель, размер)
 Склад ноутбуков(тип ноутбука, количество, цена)
 Продажи(склад ноутбуков, дата продажи, количество)
 */
@Entity
@Table(name = "Notebook")
public class Notebook {
    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
    private Long id;
    @Column(name ="MODEL")
    private String model;
    @Column(name ="DATE")
    private Date date;
    @ManyToOne
    private Vendor vendor;//класс
    @OneToOne
    private CPU processor;//класс
    @OneToOne
    private Memory ram;//класс
    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "Notebook" )  // включить двунаправленность
    private Set<Store> storeSet = new HashSet<>();

//Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Memory getRam() {
        return ram;
    }
    public void setRam(Memory ram) {
        this.ram = ram;
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
    public Vendor getVendor() {
        return vendor;
    }
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    public CPU getProcessor() {
        return processor;
    }
    public void setProcessor(CPU processor) {
        this.processor = processor;
    }
    public Set<Store> getStoreSet() {
        return storeSet;
    }
    public void setStoreSet(Set<Store> storeSet) {
        this.storeSet = storeSet;
    }

    //Конструктора
    public Notebook() {
        model = "model";
        date = new Date();
        vendor = null;
        processor = null;
        ram = null;
    }
    public Notebook(String model, Date date) {
        this.model = model;
        this.date = date;
        vendor = null;
        processor = null;
        ram = null;
    }
    public Notebook(String model, Date date, Vendor vendor, CPU processor, Memory ram) {
        this.model = model;
        this.date = date;
        this.vendor = vendor;
        this.processor = processor;
        this.ram = ram;
    }
    public Notebook(String model, Date date, Vendor vendor, CPU processor, Memory ram, Set<Store> storeSet) {
        this.model = model;
        this.date = date;
        this.vendor = vendor;
        this.processor = processor;
        this.ram = ram;
        this.storeSet = storeSet;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", date=" + date +
                ", vendor=" + vendor +
                ", processor=" + processor +
                ", ram=" + ram +
                '}';
    }
}
