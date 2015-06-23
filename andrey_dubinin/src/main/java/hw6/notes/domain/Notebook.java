package hw6.notes.domain;

import javax.persistence.*;
import java.sql.Date;


/**
 * Created by jax on 21.06.15.
 */
@Entity
@Table(name="notebooks")

public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "SEQ_ID", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "id")
    private Long id;
    @Column(name ="serial")
    private String serial;
    @Column(name="vendor")
    private String vendor;
    @Column(name="model")
    private String model;
    @Column(name="manufacture_date")
    private Date manufacture_date;
    @Column (name = "price")
    private Double price;
    public Notebook(String serial,String vendor,String model, Date manufacture_date,Double price){
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufacture_date =manufacture_date;
        this.price = price;
    }


    public String getSerial() {
        return serial;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
