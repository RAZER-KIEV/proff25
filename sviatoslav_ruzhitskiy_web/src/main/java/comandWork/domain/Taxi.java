package comandWork.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

//package Taxi.Domain;

//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.util.Date;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;
import java.util.Date;

/**
 * Created by jul on 14.07.2015.
 */


@Component
@Entity
@Table(name="TAXI")
public class Taxi {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "TAXI_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "TAXI_ID")
    private Long id;
    @Column(name = "CAR_NUMBER")
    private Integer carnumb;
    @Column(name = "NAME_DRIVER", unique = true)
    private String name;
    @Column(name = "CAR_MODER")
    private String carmodel;
    @Column(name = "PHONE_NUMBER_DRIVER")
    private Integer number;

    public Taxi() {
    }

    public Taxi(Integer carnumb, String name, String carmodel, Integer number) {
        this.carnumb = carnumb;
        this.name = name;
        this.carmodel = carmodel;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCarnumb() {
        return carnumb;
    }

    public void setCarnumb(Integer carnumb) {
        this.carnumb = carnumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                ", carnumb=" + carnumb +
                ", name='" + name + '\'' +
                ", carmodel='" + carmodel + '\'' +
                ", number=" + number +
                '}';
    }
}

