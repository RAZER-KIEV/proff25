package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by jax on 05.07.15.
 */
@Entity
@Table(name="memory")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "SEQ_MEMORY_ID", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "MEMORY_ID")
    private Long id;
    @Column(name="VENDOR")
    private Vendor vendor;
    @Column(name="SIZE")
    private Integer size;

    public Memory(){

    }

    public Memory(Vendor vendor,Integer size){
        this.size=size;
        this.vendor=vendor;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
