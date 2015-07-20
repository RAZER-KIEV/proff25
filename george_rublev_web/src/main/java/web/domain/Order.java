package web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by george on 19.07.15.
 */
@Entity
@Table(name = "ORDER")
public class Order {
    @Id
    @Column(name = "ID")
    private Integer id;


}
