package hw8.taxi.domain;

import javax.persistence.*;

/**
 * Created by Well on 14.07.2015.
 */
@Entity
@Table(name = "DRIVERS")
public class Taxi {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "DRIVERS_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String tel;

    @Column(name = "CAR_MODEL")
    private String modelCar;

    @Column(name = "CAR_NUMBER")
    private String numberCar;

    public Taxi() {
    }

    public Taxi(String name, String tel, String modelCar, String numberCar) {
        this.name = name;
        this.tel = tel;
        this.modelCar = modelCar;
        this.numberCar = numberCar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    @Override
    public String toString() {
        return new String("Drivers name: "+name+"; Phone: "+tel+"; Car: "+modelCar+
                "; Number: "+numberCar+".");
    }

}