package hw7.springnotes.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ПК on 25.06.2015.
 */
@Component
@Entity
@Table(name = "MEM")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMs_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "MEMORY_ID")
    private Long id;

    @Column(name = "MEM_VENDOR")
    private String memVendor;

    @Column(name = "MEM_SIZE")
    private Integer size;

    public Memory(){}
    public Memory(String memVendor, Integer size){
        this.memVendor = memVendor;
        this.size = size;
    }
    public Long getId(){
        return id;
    }
    public String getMemVendor(){
        return memVendor;
    }
    public Integer getSize(){return size;}

    public String toString(){
        return "MEMORY CARD.  id-> "+id+" mem_vendor - > "+memVendor+" size-> "+size;
    }
}
