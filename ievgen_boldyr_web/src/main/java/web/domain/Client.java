package web.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by george on 13.07.15.
 */
@Component
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
