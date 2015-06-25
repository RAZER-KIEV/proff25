package nw7.notes.domain;

import javax.persistence.*;

/**
 * Created by ПК on 25.06.2015.
 */

@Entity
@Table(name="CPUs")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPUs_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    private String cpuVendor;

    private Integer frequency;

    private String cpuModel;

    public CPU() {
    }
    public CPU(String cpuVendor, Integer frequency, String cpuModel) {
        this.cpuVendor = cpuVendor;
        this.frequency = frequency;
        this.cpuModel = cpuModel;
    }
    public Long getId() {
        return id;
    }
    public String getCpuVendor() {
        return cpuVendor;
    }
    public Integer getFrequency() {
        return frequency;
    }
    public String getCpuModel() {
        return cpuModel;
    }
}
