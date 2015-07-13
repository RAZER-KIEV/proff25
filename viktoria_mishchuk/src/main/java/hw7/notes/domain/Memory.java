package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by viktoria
 * Project:.hw7.domain
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
 * Память(производитель, размер)
 */

@Entity
@Table (name = "MEMORY")
public class Memory {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_MEMORY_ID", allocationSize = 1, initialValue = 1)

    @Column (name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;

    @Column (name = "SIZE")
    private Double size;

    public Memory (){

    }

    public Memory (Vendor vendor, Double size){
        this.vendor = vendor;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
