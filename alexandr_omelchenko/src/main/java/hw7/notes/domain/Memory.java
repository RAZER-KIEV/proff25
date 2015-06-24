package hw7.notes.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Memory")
public class Memory {
    private Vendor vendor;
    private Long ramSize;
}
