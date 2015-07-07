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
public class Company {

    private Long id;
    private String name;
    private Double account;
    private Director director;
    private Car car;

    public Company() {

    }

    public Company(String name, Double account) {
        this.name = name;
        this.account = account;
    }

    public Company(String name, Double account, Director director, Car car) {
        this.name = name;
        this.account = account;
        this.director = director;
        this.car = car;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    @Value("SMK")
    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Double getAccount() {
        return account;
    }

    @Value("25600.10")
    public void setAccount(Double account) {
        this.account = account;
    }

    @OneToOne
    public Director getDirector() {
        return director;
    }

    @Autowired(required = true)
    public void setDirector(Director director) {
        this.director = director;
    }

    @OneToOne
    public Car getCar() {
        return car;
    }

    @Autowired(required = true)
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return new String("Company name is: " + name + ", count: " + account + ", director is: " + director.getName() + ", car: " + car.getModel() + ".");
    }
}
