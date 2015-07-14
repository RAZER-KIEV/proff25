package hw7.notes.domain;

/**
 * Created by Віктор on 7/11/2015.
 */
public class Memory {
    private String vendor;
    private double size;

    public Memory(){}

    public Memory(String vendor, double size){
        this.vendor = vendor;
        this.size = size;
    }
    public String getVendor(){
        return vendor;
    }
    public double getSize(){
        return size;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public void setSize(double size){
        this.size = size;
    }
    public void print(){
        System.out.print(vendor +" "+ size+" ");
    }
}
