package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Роман on 25.06.2015.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {

    @Id
    @Column(name = "MEMORY_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "MEMORY_VENDOR")
    private String vendor;

    @Column(name = "MEMORY_SIZE")
    private int size;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memory", cascade = CascadeType.ALL)
    private Set<Notebook> notebookSet = new HashSet<>();

    public Memory() {
    }

    public Memory(String vendor, int size) {
        this.vendor = vendor;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Set getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set notebookSet) {
        this.notebookSet = notebookSet;
    }

    public boolean equals(Memory memory) {
        return this.vendor.equalsIgnoreCase(memory.getVendor()) && this.size == memory.getSize();
    }
}
