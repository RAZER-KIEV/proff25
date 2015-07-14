package scrum.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "DRIVERS")
public class Driver {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "DRIVERS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "DRIVER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CAR_MODEL")
    private String carModel;
    @Column(name = "CAR_NUMBER")
    private String number;
    @Column(name = "PHONE")
    private String phone;


    public Driver() {
    }

    public Driver(String name, String carModel, String number, String phone) {
        this.name = name;
        this.carModel = carModel;
        this.number = number;
        this.phone = phone;
    }

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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carModel='" + carModel + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
