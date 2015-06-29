package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    private Vendor vendor;
    @Column(name = "SIZE_MEM")
    private Long sizeMemory;

    public Memory () {

    }

    public Memory(Vendor vendor, Long sizeMemory){
        this.vendor = vendor;
        this.sizeMemory = sizeMemory;
    }

    public void setVendor (Vendor vendor) {
        this.vendor = vendor;
    }

    public void setSizeMemory (Long sizeMemory) {
        this.sizeMemory = sizeMemory;
    }

    public Vendor getVendor () {
        return  this.vendor;
    }

    public Long getSizeMemory () {
        return this.sizeMemory;
    }
}
