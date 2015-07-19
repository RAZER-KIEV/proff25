package taxi.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entities: Long id,
 * String name,
 * String model,
 * String number,
 * String phone
 * + connection @OneToMany Order
 */
@Entity
@Table(name = "TaxiDrivers")
public class TaxiDriver {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "TDRIVER_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAMES")
    private String name;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "NUMBEROK")
    private String number;
    @Column(name = "PHONE_NUM")
    private String phone;
    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "taxiDriver")  // включить двунаправленность
    private Set<Order> orderSet = new HashSet<>();

    public TaxiDriver() {
    }

    public TaxiDriver(String name, String model, String number, String phone) {
        this.name = name;
        this.model = model;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public void orderAdd(Order order) {
        orderSet.add(order);
    }

    @Override
    public String toString() {
        return "TaxiDriver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", phone='" + phone + '\'' +
                '}';

    }
}
