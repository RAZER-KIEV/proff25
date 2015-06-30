package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEM_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MEMORY_ID")
    private Long id;
    @ManyToOne
    private Vendor vendor;
    @Column(name = "MEM_SIZE")
    private Long size;
    @OneToMany(mappedBy = "memory",cascade = CascadeType.ALL)
    private Set<Notebook> notebookSet = new HashSet<>();

    public Memory(){

    }

    public Memory(Long size, Vendor vendor) {
        this.size = size;
        this.vendor = vendor;
    }

    public Memory(Long id, Vendor vendor, Long size) {
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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void print(){
        System.out.print(id+" "+vendor.getName()+" "+size);
    }
}
