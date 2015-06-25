package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by ПК on 25.06.2015.
 */
@Entity
@Table(name = "MEMORYs")
public class Memory {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORYs_ID",
    allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "sequence")
    private Long id;

    private String memVendor;

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
    public Integer getSize(){
        return size;
    }
}
