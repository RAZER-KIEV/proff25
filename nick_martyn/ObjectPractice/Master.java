package ObjectPractice;

/**
 * Created by User on 25.05.2015.
 */
public class Master {
    int age;
    String name;
    String lastname;
    Cat cat;
    Mouse mouse;
    @Override
    public String toString() {
        return " Master:" + name+ " "+lastname +" "+age+""+cat+""+mouse+""  ;
    }
}
