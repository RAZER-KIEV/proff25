package session5;

/**
 * Created by just1ce on 01.06.2015.
 */
public class Person {
    private String name = "";
    private int age;
    public Person(){

    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    @Override
    public boolean equals(Object o){
        return true;
    }
}
