package session13;

/**
 * Created by RAZER on 29.06.2015.
 */
public class Person {
 private String name;
    private int age;

    public Person(){}

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;

    }
    public String toString(){
        return "name = "+name+" age = " + age;
    }
}
