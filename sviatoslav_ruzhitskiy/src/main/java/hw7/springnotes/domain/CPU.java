package hw7.springnotes.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ПК on 25.06.2015.
 */
@Component
@Entity
@Table(name="CPUs")
public class CPU {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPUs_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.PERSIST} )
    private Vendor cpuVendor;

    private Integer frequency;

    private String cpuModel;

    public CPU() {
    }
    public CPU(Vendor cpuVendor, Integer frequency, String cpuModel) {
        this.cpuVendor = cpuVendor;
        this.frequency = frequency;
        this.cpuModel = cpuModel;
    }
    public Long getId() {
        return id;
    }
    public Vendor getCpuVendor() {
        return cpuVendor;
    }
    public Integer getFrequency() {
        return frequency;
    }
    public String getCpuModel() {
        return cpuModel;
    }
    public String toString(){
        return "CPU. id-> "+id+"; freq-> "+frequency+" CPU_vendor -> "+cpuVendor+"  Model -> "+cpuModel;
    }
}
