package hw7.notes.domain;

import javax.persistence.*;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name="CPU")
public class CPU {
    /*
    Процессоры:
    -производитель,
    -частота,
    -модель.
     */

    private Long id;
    private String producer;
    private Double frequency;
    private String model;
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    @Column
    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }
    @Column
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public  String toString(){
        return new String("CPU id: "+id+", cpu producer: "+producer+", frequency: "+frequency+", model: "+model+".");
    }
}
