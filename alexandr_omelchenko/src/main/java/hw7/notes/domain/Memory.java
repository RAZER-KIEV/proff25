package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Memory")
public class Memory {

    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
     private Long id;
    @Column(name ="RAM_SIZE")
     private Long ramSize;

    @ManyToOne
    private Vendor vendor;//класс
    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "ram" )  // включить двунаправленность
    private Set<Notebook> noteSet = new HashSet<>();

//Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRamSize() {
        return ramSize;
    }
    public void setRamSize(Long ramSize) {
        this.ramSize = ramSize;
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
    public Memory() {
        ramSize=2048L;
        vendor=null;
    }
    public Memory(Long ramSize) {
        this.ramSize = ramSize;
        vendor=null;
    }
    public Memory(Long ramSize, Vendor vendor) {
        this.ramSize = ramSize;
        this.vendor = vendor;
    }
    public Memory(Long ramSize, Vendor vendor, Set noteSet) {
        this.ramSize = ramSize;
        this.vendor = vendor;
        this.noteSet = noteSet;
    }

    public void addNoteBook(Notebook note) {
        noteSet.add(note);
    }
    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", ramSize=" + ramSize +
                ", vendor=" + vendor +
                '}';
    }
}
