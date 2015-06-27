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
    private Long id;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "VALUE")
    private String value;
    public Memory(String value, String manufacturer) {
        this.value = value;
        this.manufacturer = manufacturer;
    }

    public Memory() {

    }

    public Memory(Long id, String vendor, Long size) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void print(){
        System.out.print(id+" "+manufacturer+" "+value);
    }
}
