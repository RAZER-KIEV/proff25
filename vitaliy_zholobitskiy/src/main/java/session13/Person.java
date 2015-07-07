package session13;

/**
 * Created by just1ce on 29.06.2015.
 */
public class Person {
    private String name;
    private int age;
    public Person(int age){
        this.age=age;
    }
    public Person(String name){
        this.name=name;
    }
    public Person(int age,String name){
        this.name=name;
        this.age=age;
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
    public String toString(){
        return name+" "+age;
    }
}
