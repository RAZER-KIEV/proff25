package session5;

/**
 * Created by Роман on 01.06.2015.
 */
public class Person {
    private String name = "";
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public boolean equals (Object person) {
        Person pers = (Person) person;
        return this.name.equalsIgnoreCase(pers.name) && this.age == pers.age;
    }

}
