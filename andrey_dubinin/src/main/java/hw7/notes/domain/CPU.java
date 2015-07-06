package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by jax on 05.07.15.
 */
@Entity
@Table(name="cpu")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence",sequenceName = "SEQ_CPU_ID", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence")
    @Column(name = "CPU_ID")
    private Long id;
    @Column(name="VENDOR")
    private Vendor vendor;
    @Column(name="FREQUENCY")
    private Double frequency;
    @Column(name="MODEL")
    private String model;

    public CPU(){

    }

    public CPU(Vendor vendor,Double frequency,String model){
        this.vendor=vendor;
        this.model=model;
        this.frequency=frequency;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
