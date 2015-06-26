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
    private String id;

    @Column(name = "NAME")
    private String name;

    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
