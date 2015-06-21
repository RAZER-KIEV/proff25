package hw6.notes.domain;

import javax.persistence.*;
import java.util.Date;

/*
 * Таблица ноутбуки имеет следующую структуру
 * (id, serial, vendor, model, manufacture date, price)
 */

@Entity
@Table(name="NOTEBOOKS")
public class Notebook {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOK_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;

    @Column(name = "NOTEBOOK_SERIALNUMBER")
    private String serialNumber;

    @Column(name = "NOTEBOOK_VENDOR")
    private String vendor;

    @Column(name = "NOTEBOOK_MODEL")
    private String model;

    @Column(name = "NOTEBOOK_MANUFACTUREDATE")
    private Date manufactureDate;

    @Column(name = "NOTEBOOK_PRICE")
    private Double price;

    public Notebook() {
    }

    public Notebook(String serialNumber, String vendor, String model, Date manufactureDate, Double price) {
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
