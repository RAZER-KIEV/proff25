package hw7.notes.domain;

/**
 * Created by Віктор on 7/5/2015.
 */
public class Vendor {
    private String name;

    public Vendor(){}

    public Vendor(String name){
        this.name = name;
    }
    public String getNameVendor(){
        return name;
    }
    public void setNameVendor(String name){
        this.name = name;
    }
    public void print(){
        System.out.println("Vendor:  " + name);
    }
}
