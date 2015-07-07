package session13.Task1.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ivan on 29.06.15.
 */
@Entity
@Table(name = "DIRECTORS")
@Component
public class Director {

    private Long id;
    private String name;

    public Director() {

    }

    public Director(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Value("Baleoz")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new String("Director name is: " + name + ".");
    }
}
