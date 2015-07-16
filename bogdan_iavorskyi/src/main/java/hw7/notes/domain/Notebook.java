package hw7.notes.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="NOTEBOOKS")
public class Notebook {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "MODELNAME")
    private String modelName;

    @ManyToOne
    private CPU cpu;

    @ManyToOne
    private Memory memory;

    @Column(name = "DATETIME")
    private LocalDate dateTime;

    @OneToMany(mappedBy = "notebook", cascade = CascadeType.ALL)
    private Set<Store> stores = new HashSet<>();

    public Notebook() {
    }

    public Notebook(Vendor vendor, String modelName, CPU cpu, Memory memory, LocalDate dateTime) {
        this.vendor = vendor;
        this.modelName = modelName;
        this.cpu = cpu;
        this.memory = memory;
        this.dateTime = dateTime;
    }

    public Notebook(Long id, Vendor vendor, String modelName, CPU cpu, Memory memory, LocalDate dateTime) {
        this.id = id;
        this.vendor = vendor;
        this.modelName = modelName;
        this.cpu = cpu;
        this.memory = memory;
        this.dateTime = dateTime;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Notebook notebook = (Notebook) obj;
        if (Objects.equals(vendor, notebook.vendor)
                && Objects.equals(modelName, notebook.modelName)
                && Objects.equals(cpu, notebook.cpu)
                && Objects.equals(memory, notebook.memory)
                && Objects.equals(dateTime, notebook.dateTime))
        {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vendor) + Objects.hashCode(modelName) + Objects.hashCode(cpu)
                + Objects.hashCode(memory) + Objects.hashCode(dateTime);
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "vendor=" + vendor +
                ", modelName='" + modelName + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", dateTime=" + dateTime +
                '}';
    }
}
