package session1;

/**
 * Created by Роман on 18.05.2015.
 */
public class Currency {
    private String name;
    private double kurs;
    private int numPerDay;
    private boolean hasCurrency;

    public Currency(String name, double kurs, int numPerDay, boolean hasCurrency) {
        this.name = name;
        this.kurs = kurs;
        this.numPerDay = numPerDay;
        this.hasCurrency = hasCurrency;
    }

    @Override
    public boolean equals(Object obj1) {
        if(obj1 == null) {
            return false;
        }
        if (obj1 == this) {
            return true;
        }
        if(obj1.getClass() != getClass()) {
            return false;
        }
        Currency obj = (Currency) obj1;
        if (name != null
                && this.name.equals(obj.name) == true
                && this.kurs ==  obj.kurs
                && this.numPerDay ==  obj.numPerDay
                && hasCurrency ==  obj.hasCurrency)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Currency cur1 = new Currency("USD", 23, 300, true);
        Currency cur2 = new Currency("RUB", 4, 1000, true);
        Currency cur3 = new Currency("USD", 23, 300,true);
        System.out.println(cur1.equals(cur2));
        System.out.println(cur3.equals(cur1));
    }
}
