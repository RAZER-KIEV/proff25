package hw6.notes.domain;

import javax.persistence.*;

/**
 * Created by Well on 17.06.2015.
 */
@Entity
@Table(name = "notebooks")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "NOTEBOOKS_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "serial")
    private String serial;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacture_date")
    private String manufactureDate;

    @Column(name = "price")
    private Double price;

    public Notebook(){}

    public Notebook(String serial, String vendor, String model, String manufactureDate,
                    Double price){
        this.serial = serial;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
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

    public String getManufactureDate() {
        return manufactureDate;
    }

    public Double getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getId() + "   " + getVendor() + "   " + getModel() + "   " + getSerial() + "   " +
                getManufactureDate() + "   " + getPrice();
    }
}
