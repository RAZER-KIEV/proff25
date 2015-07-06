package hw7.springnotes.domain;

import hw7.notes.domain.Vendor;

import javax.persistence.*;

/**
 * Created by Sveta on 6/25/2015.
 * (производитель, размер)
 */
@Entity
@Table(name = "MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORIES_ID",
            allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MEMORIES_ID")
    private long id;
    @ManyToOne
    private hw7.notes.domain.Vendor vendor;
    private Integer capacity;

    public Memory() {
    }

    public Memory(hw7.notes.domain.Vendor vendor, Integer capacity) {
        this.vendor = vendor;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public hw7.notes.domain.Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
