package hw7.notes.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "Stores")
public class Sales {
    private Store store;
    private Date saleDate;
    private Long count;
}
