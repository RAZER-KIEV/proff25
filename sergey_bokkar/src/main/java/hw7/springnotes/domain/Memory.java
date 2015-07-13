package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Well on 29.06.2015.
 */
@Entity
@Table(name = "memory")
public class Memory {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "memory_id")
    private Long memId;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "memory_size")
    private Long memSize;

    public Memory(){}

    public Memory(Vendor vendor, Long size){
        memSize = size;
        this.vendor = vendor;
    }

    public Long getMemId() {
        return memId;
    }

    public Vendor getMemVendor() {
        return vendor;
    }

    public void setMemVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Long getMemSize() {
        return memSize;
    }

    public void setMemSize(Long memSize) {
        this.memSize = memSize;
    }
}
