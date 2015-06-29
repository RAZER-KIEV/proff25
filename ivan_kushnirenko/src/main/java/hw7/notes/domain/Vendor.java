package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {

    private Long id;
    private String name;
    private Set<Notebook> notebookSet = new HashSet<>();

    public Vendor() {
        this("vendor");
    }

    public Vendor(Vendor vendor) {
        this.name = vendor.getName();
    }

    public Vendor(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "vendor_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
    }

    @Override
    public String toString() {
        return new String("VENDOR id is: " + id + ", name is: " + name + ".");
    }
}
