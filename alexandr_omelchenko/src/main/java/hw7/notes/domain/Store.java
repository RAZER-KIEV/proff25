package hw7.notes.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Stores")
public class Store {
    private Notebook nb;
     private Long count;
     private Double price;
}
