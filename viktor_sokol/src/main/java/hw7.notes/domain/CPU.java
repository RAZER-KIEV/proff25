package hw7.notes.domain;

/**
 * Created by Віктор on 7/11/2015.
 */
public class CPU {
    private String vendor;
    private float frequency;
    private String model;

    public CPU(String vendor, float frequency, String model ){
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
    }
    public String getVendorCPU(){
        return vendor;
    }
    public double getFrequency(){
        return frequency;
    }
    public String getModel(){
        return model;
    }
    public void setCPUVendor(String vendor){
        this.vendor = vendor;
    }
    public void setCPUfrequensy(float frequency){
        this.frequency = frequency;
    }
    public void setCPUModel (String model){
        this.model = model;
    }
    public void print(){
        System.out.print(vendor +" "+ model+" "+frequency+" ");
    }
}
