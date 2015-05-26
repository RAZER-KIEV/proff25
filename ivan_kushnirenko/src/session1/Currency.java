package session1;

/**
 * Created by ivan on 18.05.15.
 */
public class Currency {
    Currency(String name, double course, int dayLimit, boolean presence) {
        this.name = name;
        this.course=course;
        this.dayLimit = dayLimit;
        this.presence = presence;
    }
    private String name;
    private double course;
    private int dayLimit;
    private boolean presence;

    @Override
    public boolean equals(Object obj) {
        if (obj==this){
            return true;
        }
        if (obj==null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())){
           Currency tmp = (Currency)obj;
            if(tmp.name!=null && name.equals(tmp.name)
                    && Double.compare(this.course,tmp.course) == 0
                    && dayLimit==tmp.dayLimit
                    && presence==tmp.presence){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Currency usd = new Currency("usd",21.50,200,true);
        Currency usd2 = new Currency("usd",21.50,200,true);
        Currency eu = new Currency("euro",34,150,true);
        System.out.println(eu.equals(usd2));
    }

}
