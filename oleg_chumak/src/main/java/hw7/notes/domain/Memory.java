package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by oleg on 24.06.15.
 * Память(производитель, размер)
 */
@Entity
@Table(name = "MEMORY")
public class Memory {

    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORY_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Vendor vendor;

    @Column(name = "CAPACITY")
    private Long capacity;

    public Memory(Vendor vendor, Long capacity) {
        this.vendor = vendor;
        this.capacity = capacity;
    }

    public Memory() {
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", capacity=" + capacity +
                '}';
    }
}
