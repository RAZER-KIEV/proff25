package hw7.springnotes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 24.06.15.
 */
@Entity
@Table(name = "MEMORY")
public class Memory {

    private Long id;
    private String producer;
    private Integer size;
    private Set<Notebook> notebookSet = new HashSet<>();

    public Memory() {
        this("producer", 2048);
    }

    public Memory(Memory memory) {
        this.producer = memory.getProducer();
        this.size = memory.getSize();
    }

    public Memory(String producer, Integer size) {
        this.producer = producer;
        this.size = size;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "memory_producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Column(name = "memory_size")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @OneToMany(mappedBy = "memory", cascade = CascadeType.ALL)
    public Set<Notebook> getNotebookSet() {
        return notebookSet;
    }

    public void setNotebookSet(Set<Notebook> notebookSet) {
        this.notebookSet = notebookSet;
    }

    @Override
    public String toString() {
        return new String("MEMORY id: " + id + ", memory producer: " + producer + ", memory size: " + size + ".");
    }
}
