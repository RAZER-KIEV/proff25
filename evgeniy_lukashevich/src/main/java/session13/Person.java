package session13;

/**
 * Created by Jeckgehor on 29.06.2015.
 */
public class Person {

    private String name;
    private int age;

    public Person (String name) {
        this.name = name;
    }

    public Person (int age) {
        this.age = age;
    }

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getName () {
        return this.name;
    }

    public int getAge () {
        return this.age;
    }

    @Override
    public String toString() {
        return "Name: " + name + " , Age: " + age;
    }
}
