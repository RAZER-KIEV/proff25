package hw7.springnotes.domain;

import javax.persistence.*;

/**
 * Created by oleg on 24.06.15.
 * Производители(имя)
 */

@Entity
@Table(name = "VENDOR")
public class Vendor {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_VENDOR_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name="ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
