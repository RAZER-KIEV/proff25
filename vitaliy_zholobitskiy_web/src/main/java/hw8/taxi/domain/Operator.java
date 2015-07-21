package hw8.taxi.domain;


import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "OPERATORS")
public class Operator {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "OP_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "OP_ID")
    private Long id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String pass;
    @Column(name = "DATE_REG")
    private Date date;


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

    public Operator() {
    }

    public Operator( String login, String pass, Date date) {
        this.login=login;
        this.pass=pass;
        this.date=date;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", date=" + date +
                '}';
    }
}


