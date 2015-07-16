package hw7.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "STORES")
public class Store {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_STORE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Notebook notebook;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE")
    private Integer price; // in cents

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL)
    private Set<Sales> sales = new HashSet<>();

    public Store() {
    }

    public Store(Notebook notebook, Integer price, Integer quantity) {
        this.notebook = notebook;
        this.price = price;
        this.quantity = quantity;
    }

    public Store(Long id, Notebook notebook, Integer quantity, Integer price) {
        this.id = id;
        this.notebook = notebook;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Store lot = (Store) obj;
        if (Objects.equals(notebook, lot.notebook)
                && Objects.equals(quantity, lot.quantity)
                && Objects.equals(price, lot.price)
           ) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(notebook);
        result = 31 * result + Objects.hashCode(quantity);
        result = 31 * result + Objects.hashCode(price);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "notebook=" + notebook +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
