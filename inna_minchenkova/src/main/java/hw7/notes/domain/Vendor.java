package hw7.notes.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Inna on 27.06.2015.
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "VENDOR_ID")
    private long id;

    @Column(name = "VENDOR_NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vendor")
    @Fetch(FetchMode.SELECT)
    private Set<Notebook> notebookSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vendor")
    @Fetch(FetchMode.SELECT)
    private Set<CPU> cpuSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vendor")
    @Fetch(FetchMode.SELECT)
    private Set<Memory> memorySet;

    public Vendor(){

    }

    public Vendor(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
    }

    public Set<CPU> getCpuSet() {
        return cpuSet;
    }

    public void setCpuSet(Set<CPU> cpuSet) {
        this.cpuSet = cpuSet;
    }

    public Set<Memory> getMemorySet() {
        return memorySet;
    }

    public void setMemorySet(Set<Memory> memorySet) {
        this.memorySet = memorySet;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
