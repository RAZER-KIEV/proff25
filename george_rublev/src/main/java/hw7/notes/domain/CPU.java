package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by george on 26.06.15.
 */
@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @Column(name = "CPU_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "model")
    private String model;

    public CPU(String manufacturer, String frequency, String model) {
        this.manufacturer = manufacturer;
        this.frequency = frequency;
        this.model = model;
    }

    @OneToMany(mappedBy = "cpu",cascade = CascadeType.ALL)
    private Set<Notebook> notebookSet = new HashSet<>();

    public CPU() {
    }

    public CPU(String frequency, String model) {
        this.frequency = frequency;
        this.model = model;
    }

    public CPU(Long id, String frequency, String model) {
        this.id = id;
        this.frequency = frequency;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void print(){
        System.out.print(id+" "+model+" "+frequency+" ");
    }
}
