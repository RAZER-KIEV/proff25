package lection05;

import javax.persistence.*;


/**
 * создать класс регион, который соответствует таблице REGIONS в схеме HR
 * создать регион Антарктида
 * поменять ему имя на Антарктика
 */

@Entity
@Table(name = "REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "REGIONS_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")
    private Long id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region(){
    }

    public Region(String name) {
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

    public void print(){
        System.out.println("ID= "+id+", name= "+name);
    }
}
