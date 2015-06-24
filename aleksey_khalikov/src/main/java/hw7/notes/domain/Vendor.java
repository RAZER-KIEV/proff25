package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by GFalcon on 24.06.15.
 *
 * Производители(имя)
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {

    @Id
    @SequenceGenerator(name = "myseq", sequenceName = "SEQ_VENDOR", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @OneToMany(mappedBy = "vendor",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private Set<Notebook> notebookSet;

    @OneToMany(mappedBy = "vendor",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private Set<CPU> cpuSet;

    @OneToMany(mappedBy = "vendor",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private Set<Memory> memorySet;

    public Vendor(){
        notebookSet = new HashSet<Notebook>();
        cpuSet = new HashSet<CPU>();
        memorySet = new HashSet<Memory>();
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return Objects.equals(id, vendor.id) &&
                Objects.equals(name, vendor.name) &&
                Objects.equals(notebookSet, vendor.notebookSet) &&
                Objects.equals(cpuSet, vendor.cpuSet) &&
                Objects.equals(memorySet, vendor.memorySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, notebookSet, cpuSet, memorySet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void addNotebook(Notebook notebook){
        this.notebookSet.add(notebook);
    }


    public Set<CPU> getCpuSet() {
        return cpuSet;
    }

    public void setCpuSet(Set<CPU> cpuSet) {
        this.cpuSet = cpuSet;
    }

    public void addCPU(CPU cpu){
        this.cpuSet.add(cpu);
    }

    public Set<Memory> getMemorySet() {
        return memorySet;
    }

    public void setMemorySet(Set<Memory> memorySet) {
        this.memorySet = memorySet;
    }

    public void addMemory(Memory memory){
        this.memorySet.add(memory);
    }
}
