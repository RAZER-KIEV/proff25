package ObjectPractice;

/**
 * Created by User on 25.05.2015.
 */


public class Main {
  public static Cat cat = new Cat();
    public static Mouse mouse= new Mouse();
  public static Master master = new Master();
    public static void main(String[] args) {

        cat.setAge(5);
        cat.setName("Anya");
        cat.setType("Pers");
        master.age = 30;
        master.lastname = "Pupkin";
        master.name ="Vasya";
        master.cat = cat;
        mouse.age = 1;
        mouse.color = "grey";
        master.mouse = mouse;
        System.out.println( master);



    }
}
