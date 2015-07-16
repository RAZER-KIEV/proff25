package hw7.notes.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SALESS")
public class Sales {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_SALES_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @ManyToOne
    private Store lot;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    public Sales() {
    }

    public Sales(Store lot, Integer quantity, LocalDateTime dateTime) {
        this.lot = lot;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public Sales(Long id, Store lot, Integer quantity, LocalDateTime dateTime) {
        this.id = id;
        this.lot = lot;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getLot() {
        return lot;
    }

    public void setLot(Store lot) {
        this.lot = lot;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Sales sale = (Sales) obj;
        if (Objects.equals(lot,sale.lot)
            && Objects.equals(quantity,sale.quantity)
            && Objects.equals(dateTime,sale.dateTime)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lot) + Objects.hashCode(quantity) + Objects.hashCode(dateTime);
    }

    @Override
    public String toString() {
        return "Sales{" +
                "lot=" + lot +
                ", quantity=" + quantity +
                ", dateTime=" + dateTime +
                '}';
    }
}
