package session13;

/**
 * Created by Sveta on 6/29/2015.
 */

public class Person {
    private String name;
    private int age;

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
    public String toString() {
        return "Name: " + getName() + "; Age: " + getAge();
    }

    public Person() {
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public Person(int age) {

        this.age = age;
    }

    public Person(String name) {

        this.name = name;
    }
}
