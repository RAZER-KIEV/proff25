package session01;

/**
 * Created by Jeckgehor on 18.05.2015.
 */
public class Currency {

    public String name;
    public double course;
    public int sum;
    public boolean availability;

    public Currency (String name, double course, int sum, boolean availability) {
        this.name = name;
        this.course = course;
        this.sum = sum;
        this.availability = availability;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() != obj.getClass())
            return false;

        Currency other = (Currency) obj;
        if (this.name.equals(other.name)
                && Double.compare(this.course, other.course) == 0
                && this.sum == other.sum
                && this.availability == other.availability) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {

        Currency cur1 = new Currency("$", 3.20, 200, false);
        Currency cur2 = new Currency("$", 3.20, 200, false);

        System.out.println(cur1.equals(cur2));

    }
}
