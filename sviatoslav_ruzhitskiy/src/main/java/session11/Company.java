package session11;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RAZER on 22.06.2015.
 */

@Entity
@Table(name = "COMPANYES" )
public class Company {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_COMPANY_ID",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
   // @Column(name = "ID")
    private Long id;

    //@Column(name = "Name")
    private String name;

   //@Column(name = "Capital")
    private Double capital;

    @OneToMany
    //@Column(name = "Emploees")
    private Set<Emploee> emploees = new HashSet<>();

    public Company(){}
    public Company(String name, Double capital){
        this.name = name;
        this.capital = capital;
    }
    public String getName(){return name;}
    public Double getCapital(){return capital;}
    public void addEmploee(Emploee empl){
        emploees.add(empl);
    }

}
