package hw7.notes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Inna on 27.06.2015.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MEMORY_ID")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "CAPACITY")
    private String capacity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memory")
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebookSet;

    public Memory() {

    }

    public Memory(Vendor vendor, String capacity) {
        this.vendor = vendor;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
