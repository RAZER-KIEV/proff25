package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VENDORS")
public class Vendor {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDOR_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private Set<CPU> cpus = new HashSet<>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private Set<Memory> memories = new HashSet<>();

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private Set<Notebook> notebooks = new HashSet<>();

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public Vendor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Vendor vendor = (Vendor) obj;

        return name == null ? name == vendor.name : name.equals(vendor.name);
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.hashCode();
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "name='" + name + '\'' +
                '}';
    }
}
