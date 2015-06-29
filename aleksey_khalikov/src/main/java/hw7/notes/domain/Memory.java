package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by GFalcon on 24.06.15.
 *
 * Память(производитель, размер)
 */
@Entity
@Table(name = "MEMORY")
public class Memory {

    @Id
    @SequenceGenerator(name = "myseq", sequenceName = "SEQ_MEMORY", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
//    @Column(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "MSIZE")
    private Double size;

    @OneToMany(mappedBy = "memory",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private Set<Notebook> notebookSet;

    public Memory(){
        notebookSet = new HashSet<Notebook>();
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", vendor=" + vendor.toString() +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory = (Memory) o;
        return Objects.equals(id, memory.id) &&
                Objects.equals(vendor, memory.vendor) &&
                Objects.equals(size, memory.size) &&
                Objects.equals(notebookSet, memory.notebookSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendor, size, notebookSet);
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
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
}
