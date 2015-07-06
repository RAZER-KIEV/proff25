package session14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 30.06.15
 */
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
