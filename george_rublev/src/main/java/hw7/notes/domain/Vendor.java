package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by george on 26.06.15.
 */
@Entity
@Table(name = "vendor")
public class Vendor {
    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
    private Set<Notebook> notebookSet = new HashSet<>();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Vendor(){

    }

    public Vendor(String name) {
        this.name = name;
    }

    public Vendor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
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
}
