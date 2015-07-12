package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by Well on 29.06.2015
 */
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    public Vendor (){}

    public Vendor(String name){
        vendorName = name;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
