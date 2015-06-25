package hw7.notes.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Роман on 25.06.2015.
 */
@Entity
@Table(name = "VENDOR")
public class Vendor {

    @Id
    @Column(name = "VENDOR_ID")
    @SequenceGenerator(name = "sequence", sequenceName = "VENDOR_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "VENDOR_NAME")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set notebooksSet;

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getNotebooksSet() {
        return notebooksSet;
    }

    public void setNotebooksSet(Set notebooksSet) {
        this.notebooksSet = notebooksSet;
    }
}
