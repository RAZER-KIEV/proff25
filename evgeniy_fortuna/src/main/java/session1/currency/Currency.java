package session1.currency;

public class Currency {
    private String name;
    private double rate;
    private int legalAmount;
    private boolean availability;

    public Currency(String name, double rate, int legalAmount, boolean availability) {
        this.name = name;
        this.rate = rate;
        this.legalAmount = legalAmount;
        this.availability = availability;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){                       // проверка, не пытаются ли нам передать пустую ссылку
            return false;
        }
        if (obj == this){                       // проверка, не пытаются ли сравнить объект сам с собой
            return true;
        }
        if (obj.getClass() != getClass()){      // проверка, что нам передали объект того же класса
            return false;
        }
        Currency curr = (Currency) obj;

        if (name != null && name.equals(curr.name)              // проверка всех полей
            && Double.compare(rate,curr.rate) == 0
                && legalAmount == curr.legalAmount
                && availability == curr.availability){
            return true;
        }
            return false;
    }

    public static void main(String[] args) {
        Currency eur = new Currency("Euro",23.35, 5000, false);
        Currency usd = new Currency("Dollar",21.35, 5000, true);
        Currency frank = new Currency("Euro",23.35, 5000, false);
        System.out.println(eur.equals(usd));
        System.out.println(frank.equals(usd));
        System.out.println(frank.equals(eur));
        System.out.println(eur.equals(frank));
    }
}
