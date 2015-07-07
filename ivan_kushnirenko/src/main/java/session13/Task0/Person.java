package session13.Task0;

/**
 * Created by ivan on 29.06.15.
 */
public class Person {

    private String name;
    private int age;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new String("Person name: " + name + ", person age: " + age + ".");
    }

}
