package hw8.taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Table(name="DRIVERS_TAXI")
public class Driver {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "DRIVERS_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "DRIVER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private Set<Order> orderSet = new HashSet<>();

    public Driver() {
    }

    public Driver(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
