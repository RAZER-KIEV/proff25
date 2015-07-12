package hw8.taxi.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="OPERATORS")
public class Operator {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "OPER_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    private Long id;
    @Column(name = "IDENT_NUMBER")
    private String identNumb;
    @Column(name = "LOGIN", unique = true)
    private String login;
    @Column(name = "PASSWORD")
    private String pass;
    @Column(name = "REGISTRATION_DATE")
    private Date date;
    @Column(name = "CHANGE_PASS_DATE")
    private Date passDate;
    @Column(name = "COUNT_MISS_PASSWORDS")
    private Integer countMiss;
    @Column(name = "IS_BLOCKED")
    private Boolean isItBlock;
    @OneToMany(cascade = CascadeType.ALL, // каскадирование
            fetch = FetchType.EAGER,// подргужать все сразу
            mappedBy = "operator" )  // включить двунаправленность
    private Set<Order> orderSet = new HashSet<>();

    public Operator() {
    }
    public Operator(String login, String pass) {
        this.login = login;
        this.pass = pass;
        identNumb = "0000000000";
        date = new Date();
        passDate = new Date();
        countMiss = 0;
        isItBlock = false;
    }
    public Operator(String idnumb, String login, String pass) {
        this.identNumb = idnumb;
        this.login = login;
        this.pass = pass;
        date = new Date();
        passDate = new Date();
        countMiss = 0;
        isItBlock = false;
    }
    public Operator(String identNumb, String login, String pass, Date date, Date passDate, Integer countMiss, Boolean isItBlock) {
        this.identNumb = identNumb;
        this.login = login;
        this.pass = pass;
        this.date = date;
        this.passDate = passDate;
        this.countMiss = countMiss;
        this.isItBlock = isItBlock;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdentNumb() {
        return identNumb;
    }
    public void setIdentNumb(String identNumb) {
        this.identNumb = identNumb;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getPassDate() {
        return passDate;
    }
    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }
    public Integer getCountMiss() {
        return countMiss;
    }
    public void setCountMiss(Integer countMiss) {
        this.countMiss = countMiss;
    }
    public Boolean getIsItBlock() {
        return isItBlock;
    }
    public void setIsItBlock(Boolean isItBlock) {
        this.isItBlock = isItBlock;
    }
    public Set<Order> getOrderSet() {
        return orderSet;
    }
    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", identNumb='" + identNumb + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", date=" + date +
                ", passDate=" + passDate +
                ", countMiss=" + countMiss +
                ", isItBlock=" + isItBlock +
                ", orderSet=" + orderSet +
                '}';
    }
}
