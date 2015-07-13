package hw7.notes.domain;

/**
 * Created by Віктор on 7/5/2015.
 */
public class Notebook {
    private Long id;
    private String serial;
    private String vendor;
    private String model;
    private String manufactureDate;
    private Float price;

    public Notebook() {

    }
    public Notebook(Long id, String serial, String vendor, String manufactureDate, Float price) {
        this.id = id;
        this.serial = serial;
        this.vendor = vendor;
        this.manufactureDate = manufactureDate;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public void print(){
        System.out.print("Notebook: "+id+" "+vendor+" "+model+" "+
                manufactureDate+"/"+manufactureDate+"/"+manufactureDate+" ");
        System.out.println();
    }
}

