package cache.domain;

/**
 * Created by oleg on 09.07.15.
 */
public class Dom {
    private Long id;
    private String name;
    private String pass;
    private Long amount;

    @Override
    public String toString() {
        return id +
                ", " + name  +
                ", " + pass +
                ", " + amount +
                "\n";
    }

    public Dom() {
    }

    public Dom(Long id, String name, String pass, Long amount) {

        this.id = id;
        this.name = name;
        this.pass = pass;
        this.amount = amount;
    }
}
