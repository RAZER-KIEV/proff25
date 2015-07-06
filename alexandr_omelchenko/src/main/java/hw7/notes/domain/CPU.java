package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name="sequence", sequenceName="CPU_ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
     private Long id;
    @Column(name ="FREQUENCY")
     private Long frequency;
    @Column(name ="MODEL")
     private String model;

    @ManyToOne
    private Vendor vendor;//класс
    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "processor" )  // включить двунаправленность
    private Set<Notebook> noteSet = new HashSet<>();
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
    public Set<Notebook> getNoteSet() {
        return noteSet;
    }
    public void setNoteSet(Set<Notebook> noteSet) {
        this.noteSet = noteSet;
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
    public CPU(Long frequency, String model, Vendor vendor, Set noteSet) {
        this.frequency = frequency;
        this.model = model;
        this.vendor = vendor;
        this.noteSet = noteSet;
    }

    public void addNoteBook(Notebook note) {
        noteSet.add(note);
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