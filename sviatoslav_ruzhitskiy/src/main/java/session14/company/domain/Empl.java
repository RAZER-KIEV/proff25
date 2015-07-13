package session14.company.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by RAZER on 30.06.2015.
 */
@Entity
@Component

public class Empl {

    @OneToMany (fetch = FetchType.EAGER)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;


    public Empl(){}
    public Empl(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
