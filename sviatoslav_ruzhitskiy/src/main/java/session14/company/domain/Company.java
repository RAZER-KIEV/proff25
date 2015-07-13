package session14.company.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by RAZER on 30.06.2015.
 */
@Entity
@Component
public class Company {
    @OneToMany(fetch = FetchType.EAGER)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private List<Empl> emp;

    public Company(){}

    public Company(String name, List<Empl> emp) {
        this.name = name;
        this.emp = emp;
    }

    public String getName() {
        return name;
    }

    public List<Empl> getEmp() {
        return emp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmp(List<Empl> emp) {
        this.emp = emp;
    }
}
