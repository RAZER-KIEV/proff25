package hw7.notes.domain;

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

    @Column(name = "memory_vendor")
    private String memVendor;

    @Column(name = "memory_size")
    private Long memSize;

    public Memory(){}

    public Memory(String memVendor, Long memSize){
        this.memSize = memSize;
        this.memVendor = memVendor;
    }

    public Long getMemId() {
        return memId;
    }

    public String getMemVendor() {
        return memVendor;
    }

    public void setMemVendor(String memVendor) {
        this.memVendor = memVendor;
    }

    public Long getMemSize() {
        return memSize;
    }

    public void setMemSize(Long memSize) {
        this.memSize = memSize;
    }
}
