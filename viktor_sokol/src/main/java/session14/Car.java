package session14;

/**
 * Created by Віктор on 6/30/2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Car {
    private String name;

    @Autowired
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}