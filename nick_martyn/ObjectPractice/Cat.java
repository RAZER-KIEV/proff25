package ObjectPractice;

/**
 * Created by User on 25.05.2015.
 */
public class Cat {
   private int age;
   private String name;
   private String type;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return" Cat:"+ name+ " "+type+" "+age+"                   " ;
    }
}
