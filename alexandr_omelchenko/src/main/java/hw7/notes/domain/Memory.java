package hw7.notes.domain;

import javax.persistence.*;

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
    @OneToOne
    private Notebook note;//класс
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
    public Notebook getNote() {
        return note;
    }
    public void setNote(Notebook note) {
        this.note = note;
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
    public Memory(Long ramSize, Vendor vendor, Notebook note) {
        this.ramSize = ramSize;
        this.vendor = vendor;
        this.note = note;
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
