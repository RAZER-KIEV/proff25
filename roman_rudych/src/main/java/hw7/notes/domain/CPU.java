package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 25.06.2015.
 */

@Entity
@Table(name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CPU_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CPU_ID")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Vendor vendor;

    @Column(name = "CPU_FREQ")
    private int freq;

    @Column(name = "CPU_MODEL")
    private String model;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cpu",cascade = CascadeType.ALL)
    private Set<Notebook> notebookSet = new HashSet<>();

    public CPU() {
    }

    public CPU(Vendor vendor, int freq, String model) {
        this.vendor = vendor;
        this.freq = freq;
        this.model = model;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set notebookSet) {
        this.notebookSet = notebookSet;
    }

    public boolean equals(CPU cpu) {
        return this.vendor.equals(cpu.getVendor()) && this.model.equalsIgnoreCase(cpu.getModel()) &&
                this.freq == cpu.getFreq();
    }
}
