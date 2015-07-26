package web.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by george on 20.07.15.
 */

@Entity
@Table(name = "DRIVERS")
public class Drivers {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "car_num")
    private String carNum;

    @Column(name = "name")
    private String name;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "car_model")
    private String carModels;

    public Drivers() {
    }

    public Drivers(Integer id, String carNum, String name, String carNumber, String phone) {
        this.id = id;
        this.carNum = carNum;
        this.name = name;
        this.carNumber = carNumber;
        this.phone = phone;
    }

    public String getCarModels() {
        return carModels;
    }

    public void setCarModels(String carModels) {
        this.carModels = carModels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
