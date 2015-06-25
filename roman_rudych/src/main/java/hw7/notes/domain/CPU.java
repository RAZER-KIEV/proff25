package hw7.notes.domain;

import javax.persistence.*;
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

    @Column(name = "CPU_VENDOR")
    private String vendor;

    @Column(name = "CPU_FREQ")
    private int freq;

    @Column(name = "CPU_MODEL")
    private String model;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set notebookSet;

    public CPU() {
    }

    public CPU(String vendor, int freq, String model) {
        this.vendor = vendor;
        this.freq = freq;
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
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
}
