package session5;



import javax.persistence.*;


/**
 * Created by just1ce on 01.06.2015.
 */
@Entity
@Table
public class Person {
    @Id
    @Column
    private Long id;
    private String name = "";
    public Person(){
    }
    public Person(String name){
        this.name=name;

    }
    @Override
    public boolean equals(Object o){
        return true;
    }
}
