package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEMORIES")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "MEMORIES_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MEMORY_ID")
    private Long id;
    @Column(name = "VENDOR")
    private String vendor;
    @Column(name = "SIZE")
    private Long size;
    @OneToMany(mappedBy = "memory")
    private Set<Notebook> notebookSet = new HashSet<>();

    public Memory(){

    }

    public Memory(Long size, String vendor) {
        this.size = size;
        this.vendor = vendor;
    }

    public Memory(Long id, String vendor, Long size) {
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void print(){
        System.out.println(id+" "+vendor+" "+size);
    }
}
