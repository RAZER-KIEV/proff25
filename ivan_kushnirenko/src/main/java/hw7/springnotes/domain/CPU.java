package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name = "CPU")
public class CPU {

    private Long id;
    private String producer;
    private Double frequency;
    private String model;
    private Set<Notebook> notebookSet = new HashSet<>();

    public CPU() {
        this("producer", 2.46, "model");
    }

    public CPU(CPU cpu) {
        this.producer = cpu.getProducer();
        this.frequency = cpu.getFrequency();
        this.model = cpu.getModel();
    }

    public CPU(String producer, Double frequency, String model) {
        this.producer = producer;
        this.frequency = frequency;
        this.model = model;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "cpu_producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Column(name = "frequency")
    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }

    @Column(name = "cpu_model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL)
    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
    }

    @Override
    public String toString() {
        return new String("CPU id: " + id + ", cpu producer: " + producer + ", frequency: " + frequency + ", model: " + model + ".");
    }
}
