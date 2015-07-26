package web.domain;

import org.springframework.stereotype.Component;
import scala.collection.Set;
import scala.collection.mutable.HashSet;

import javax.persistence.*;

/**
 * Created by george on 16.07.15.
 */
@Component
@Entity
@Table(name = "OPERATOR")
public class Operator {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS")
    private String status;

//    @ManyToOne
//    private Order order;
//
//    @OneToMany
//    private Set<Order> order;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Operator() {
    }

    public Operator(Integer id, String login, String password, String status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

//    @OneToMany(mappedBy = "Operator", cascade = CascadeType.ALL)
//    private Set<Order> operator = new HashSet<>();



//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public Operator(Integer id, String login, String password) {
        this.id = id;
        this.login = login;

        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
