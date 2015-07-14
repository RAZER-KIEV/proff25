package session5;

/**
 * Created by jul on 01.06.2015.
 */
public class Person {
    private String name = "";
    private int age;

    public  Person(){

    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }
}
