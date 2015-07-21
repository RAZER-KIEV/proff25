package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CPUS")
public class CPU {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CPU_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @Column(name = "CLOCKRATE")
    private Integer clockRate; // in MHz

    @Column(name = "CODENAME")
    private String codeName;

    @OneToMany(mappedBy = "cpu", cascade = CascadeType.ALL)
    private Set<Notebook> notebooks = new HashSet<>();

    public CPU() {
    }

    public CPU(Vendor vendor, Integer clockRate, String codeName) {
        this.vendor = vendor;
        this.clockRate = clockRate;
        this.codeName = codeName;
    }

    public CPU(Long id, Vendor vendor, Integer clockRate, String codeName) {
        this.id = id;
        this.vendor = vendor;
        this.clockRate = clockRate;
        this.codeName = codeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Integer getClockRate() {
        return clockRate;
    }

    public void setClockRate(Integer clockRate) {
        this.clockRate = clockRate;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == this) {
            return true;
        }
        if ( obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CPU cpu = (CPU) obj;

        if ( vendor == null ? vendor == cpu.vendor : vendor.equals(cpu.vendor)
                && clockRate == null ? clockRate == cpu.clockRate : clockRate.equals(cpu.clockRate)
                && codeName == null ? codeName == cpu.codeName : codeName.equals(cpu.codeName))
        {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vendor) + Objects.hashCode(codeName) + Objects.hashCode(clockRate);
    }

    @Override
    public String toString() {
        return "CPU{" +
                "vendor=" + vendor +
                ", clockRate=" + clockRate +
                ", codeName='" + codeName + '\'' +
                '}';
    }
}
