package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by just1ce on 29.06.2015.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORY_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MEMORY_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;
    @Column(name = "MEMORY_SIZE")
    private Long size;
    @OneToMany(mappedBy = "memory",cascade = CascadeType.ALL)
    private Set<Notebook> ntbkSet = new HashSet<>();

    public Memory(){
    }

    public Memory(Long size, Vendor vendor) {
        this.size = size;
        this.vendor = vendor;
    }


    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return vendor.toString()+" "+size.toString();
    }
}
