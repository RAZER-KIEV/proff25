package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Vendor")
public class Vendor {

    @Id
    @SequenceGenerator(name="sequence", sequenceName="ID", allocationSize=1, initialValue =0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name ="ID")
    private Long id;
    @Column(name ="NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "vendor" )  // включить двунаправленность
    private Set<Notebook> noteSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "vendor" )  // включить двунаправленность
    private Set<CPU> cpuSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "vendor" )  // включить двунаправленность
    private Set<Memory> ramSet = new HashSet<>();

    //Getters&Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Notebook> getNoteSet() {
        return noteSet;
    }
    public void setNoteSet(Set<Notebook> noteSet) {
        this.noteSet = noteSet;
    }
    public Set<CPU> getCpuSet() {
        return cpuSet;
    }
    public void setCpuSet(Set<CPU> cpuSet) {
        this.cpuSet = cpuSet;
    }
    public Set<Memory> getRamSet() {
        return ramSet;
    }
    public void setRamSet(Set<Memory> ramSet) {
        this.ramSet = ramSet;
    }

    //Конструктора
    public Vendor() {
        name = "nameVendor";
    }
    public Vendor(String name) {
        this.name = name;
    }
    public Vendor(String name, Set<Notebook> noteSet, Set<CPU> cpuSet, Set<Memory> ramSet) {
        this.name = name;
        this.noteSet = noteSet;
        this.cpuSet = cpuSet;
        this.ramSet = ramSet;
    }

    public void addNoteBook(Notebook note) {
        noteSet.add(note);
    }
    public void addCpu(CPU cpu){
        cpuSet.add(cpu);
    }
    public void addRam(Memory ram){
        ramSet.add(ram);
    }
    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}