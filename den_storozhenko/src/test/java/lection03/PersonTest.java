package lection03;

/**
 * Created by Taras on 01.06.2015.
 */
public class PersonTest {
    public static void main(String[] args) {
        PersonTest personTest = new PersonTest();
        personTest.testEqualsLegal();
    }

    public void testEqualsLegal() {
        Person person = new Person();
        boolean actual = person.equals(new Person());
        boolean expected = true;

        if (expected==actual){
            System.out.println("OK");
        }
        else
            System.out.println("FAIL");
    }
}
