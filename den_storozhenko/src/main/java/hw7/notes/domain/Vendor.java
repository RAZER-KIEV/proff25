package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VENDORS")
public class Vendor {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "VENDORS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "VENDOR_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "vendor")
    private Set<Notebook> notebookSet = new HashSet<>();

    public Vendor(){

    }

    public Vendor(String name) {
        this.name = name;
    }

    public Vendor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void print(){
        System.out.println("Vendor: "+id+" "+name);
    }
}
