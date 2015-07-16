package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMORIES")
public class Memory {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORY_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "MEMORYSIZE")
    private Integer size; //MB

    @OneToMany(mappedBy = "memory", cascade = CascadeType.ALL)
    private Set<Notebook> notebooks = new HashSet<>();

    public Memory() {
    }

    public Memory(Vendor vendor, Integer size) {
        this.vendor = vendor;
        this.size = size;
    }

    public Memory(Long id, Vendor vendor, Integer size) {
        this.id = id;
        this.vendor = vendor;
        this.size = size;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Memory memory = (Memory) obj;

        if ( vendor == null ? vendor == memory.vendor : vendor.equals(memory.vendor)
                && size == null ? size == memory.size : size.equals(memory.size))
        {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vendor) + Objects.hashCode(size);
    }

    @Override
    public String toString() {
        return "Memory{" +
                "vendor=" + vendor +
                ", size=" + size +
                '}';
    }
}
