package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by viktoria
 * Project:.hw7.domain
 * 1. Создать сущности для базы данных "Магазин ноутбуков":
 * Процессоры(производитель, частота, модель)
 */

@Entity
@Table (name = "CPU")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Column (name = "ID")
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vendor vendor;

    @Column (name = "FREQUENCY")
    private Double frequency;

    @Column (name = "MODEL")
    private String model;

    public CPU(){

    }
    public CPU (Vendor vendor, Double frequency, String model){
        this.vendor = vendor;
        this.frequency = frequency;
        this.model = model;
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

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
