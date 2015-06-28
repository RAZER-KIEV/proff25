package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by GFalcon on 24.06.15.
 *
 * Процессоры(производитель, частота, модель)
 */
@Entity
@Table(name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "myseq", sequenceName = "SEQ_CPU", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.REFRESH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.DETACH})
  //  @Column(name = "VENDOR")
    private Vendor vendor;

    @Column(name = "FREQUENCY")
    private Double frequency;

    @Column(name = "MODEL")
    private String model;

    @OneToMany(mappedBy = "cpu",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private Set<Notebook> notebookSet;

    public CPU(){
        notebookSet = new HashSet<Notebook>();
    }

    @Override
    public String toString() {
        return "CPU{" +
                "id=" + id +
                ", vendor=" + vendor.toString() +
                ", frequency=" + frequency +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPU cpu = (CPU) o;
        return Objects.equals(id, cpu.id) &&
                Objects.equals(vendor, cpu.vendor) &&
                Objects.equals(frequency, cpu.frequency) &&
                Objects.equals(model, cpu.model) &&
                Objects.equals(notebookSet, cpu.notebookSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendor, frequency, model, notebookSet);
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

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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