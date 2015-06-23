package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Jeckgehor on 20.06.2015.
 */
@Entity
@Table (name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column (name = "MODEL")
    private String model;
    @Column (name = "VENDOR")
    private String vendor;
    @Column (name = "SERIAL")
    private String serial;
    @Column (name = "PRICE")
    private Double price;
    @Column (name = "MANUF_DATE")
    private Date manufactureDate;

    public Notebook(){
    }

    public Notebook (Long id, String serial, String model, String vendor, Double price, Date manufactureDate){
        this.id = id;
        this.serial = serial;
        this.model = model;
        this.vendor = vendor;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }

    public Long getId () {
        return id;
    }

    public String getModel(){
        return model;
    }

    public String getVendor (){
        return vendor;
    }

    public String getSerial() {
        return serial;
    }

    public Double getPrice (){
        return price;
    }

    public Date getManufactureDate (){
        return manufactureDate;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public void setVendor (String vendor) {
        this.vendor = vendor;
    }

    public void setSerial (String serial) {
        this.serial = serial;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    public void setManufactureDate (Date manufactureDate){
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String toString(){
        String str = "ID: " + id + ", Serial: " + serial + ", Model: " + model + ", Vendor: " + vendor + ", Price: "
                + price + ", Manufacture date: " + manufactureDate;
        return str;
    }


}
