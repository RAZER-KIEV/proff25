package session13.Task1.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by ivan on 29.06.15.
 */
@Entity
@Table
@Component
public class Car {

    private Long id;
    private String model;
    private Director director;

    public Car() {

    }

    public Car(String model, Director director) {
        this.model = model;
        this.director = director;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getModel() {
        return model;
    }

    @Value("Subaru")
    public void setModel(String model) {
        this.model = model;
    }

    @OneToOne
    public Director getDirector() {
        return director;
    }

    @Autowired
    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return new String("Car model: " + model + ", director: " + director.getName() + ".");
    }
}
