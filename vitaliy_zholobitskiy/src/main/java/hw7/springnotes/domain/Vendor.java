package hw7.springnotes.domain;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by just1ce on 29.06.2015.
 */
@Entity
@Table(name = "VENDORS")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VNDR_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "VENDOR_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
    private Set<hw7.springnotes.domain.Notebook> ntbkSet = new HashSet<>();
    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
    private Set<hw7.springnotes.domain.CPU> cpuSet = new HashSet<>();
    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
    private Set<hw7.springnotes.domain.Memory> memorySet = new HashSet<>();


    public Vendor() {
    }

    public Vendor(String name) {
       this.name=name;
    }

    public void setName(String name) {

        this.name=name;
    }


    public String getName() {

        return name;
    }
    @Override
    public String toString() {
        return name;
    }


}
