package session13;

/**
 * Created by viktoria
 * Project:.session13
 */
public class Person {

    private String name;
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String toString(){
        return "Name: " + name + ".  Age: " + age;
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
}
