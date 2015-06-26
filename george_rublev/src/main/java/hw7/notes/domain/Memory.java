package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by george on 26.06.15.
 */
@Entity
@Table(name = "memory")
public class Memory {
    @OneToMany(mappedBy = "memory",cascade = CascadeType.ALL)
    private Set<Notebook> notebookSet = new HashSet<>();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "VALUE")
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
