package session1;

/**
 * Created by viktoria on 18.05.15.
 */
public class Currency {
    private String name;
    private double kurs;
    private double amount;
    private boolean valiability;

    public Currency(){

    }

    public Currency(String name, double kurs, double amount, boolean valiability){
        this.name = name;
        this.kurs = kurs;
        this.amount = amount;
        this.valiability = valiability;
    }


    @Override
    public boolean equals(Object obj){
        if(obj ==null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (obj instanceof Currency) {  //if(obj.getClass() != getClass()) - работает более надежно.
            Currency temp = (Currency)obj;
            if(name != null
                    && this.name.equals(temp.name)
                    && this.kurs == temp.kurs //&& Double.compare(this.kurs,temp.kurs)
                    && this.amount == temp.amount
                    && this.valiability == temp.valiability){
                return true;
            }
         }
        return false;
    }


    public static void main(String[] args) {
        Currency usd = new Currency("USD", 22.5, 1000, true);
        Currency eur = new Currency("EUR", 30.25, 1000, false );
        Currency usd2 = new Currency("USD", 22.5, 1000, true);


        System.out.println(usd.equals(eur));
        System.out.println(usd.equals(usd2));


    }
}
