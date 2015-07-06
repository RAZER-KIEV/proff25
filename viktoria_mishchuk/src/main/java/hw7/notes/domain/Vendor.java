package hw7.notes.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by viktoria
 * Project:.hw7.notes
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
 * Производители(имя)
 */

@Entity
@Table (name = "VENDOR")
public class Vendor {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDOR_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @Column (name = "VENDOR_NAME")
    private String vendorName;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vendor")
    private Set<Notebook> notebooks;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vendor")
    private Set<CPU> cpus;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vendor")
    private Set<Memory> memories;

    public Vendor(){

    }

    public Vendor(String  vendorName){
        this.vendorName = vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Long getId() {
        return id;
    }

}
