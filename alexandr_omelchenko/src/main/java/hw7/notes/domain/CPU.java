package hw7.notes.domain;

import javax.persistence.*;

@Entity
@Table(name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
     private Long id;
    @Column(name ="FREQUENCY")
     private Long frequency;
    @Column(name ="MODEL")
     private String model;

    @ManyToOne
    private Vendor vendor;//класс
    @OneToOne
    private Notebook note;//класс
//Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getFrequency() {
        return frequency;
    }
    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Vendor getVendor() {
        return vendor;
    }
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    public Notebook getNote() {
        return note;
    }
    public void setNote(Notebook note) {
        this.note = note;
    }

    //Конструктора
    public CPU() {
        frequency=3L ;
        model="modelCPU";
        vendor=null;
    }
    public CPU(Long frequency) {
        this.frequency = frequency;
        model="modelCPU";
        vendor=null;
    }
    public CPU(Long frequency, String model) {
        this.frequency = frequency;
        this.model = model;
        vendor=null;
    }
    public CPU(Long frequency, String model, Vendor vendor) {
        this.frequency = frequency;
        this.model = model;
        this.vendor = vendor;
    }
    public CPU(Long frequency, String model, Vendor vendor, Notebook note) {
        this.frequency = frequency;
        this.model = model;
        this.vendor = vendor;
        this.note = note;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", frequency=" + frequency +
                ", model='" + model + '\'' +
                ", vendor=" + vendor +
                '}';
    }
}