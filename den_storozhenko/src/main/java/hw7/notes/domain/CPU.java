package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROCESSORS")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "PROCESSORS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "PROCESSOR_ID")
    private Long id;
    @ManyToOne
    private Vendor vendor;
    @Column(name = "FREQUENCY")
    private Long frequency;
    @Column(name = "MODEL")
    private String model;
    @OneToMany(mappedBy = "cpu",cascade = CascadeType.ALL)
    private Set<Notebook> notebookSet = new HashSet<>();

    public CPU(){

    }

    public CPU(Vendor vendor,Long frequency, String model) {
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    public CPU(Long id, Vendor vendor, Long frequency, String model) {
        this.id = id;
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

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

    public void print(){
        System.out.print(id+" "+model+" "+frequency+" ");
    }
}
