package week1_lesson1;

public class Valuta {
    String name;
    double kyrs;
    int kol;
    boolean presence;
    public Valuta(String a, double b, int c, boolean d) {
        name = a;
        kyrs = b;
        kol = c;
        presence = d;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==null){return false;}
        if(obj==this){return true;}
        if(obj.getClass()!=getClass()){return false;}

        Valuta val = (Valuta) obj;
        if (this.name!=null&&this.name.equals(val.name) && this.kyrs == val.kyrs && this.kol == val.kol && this.presence == (val.presence))
            return true;
        else return false;
    }
    public static void main(String[] args) {
        Valuta val1;
        Valuta val2;
        val1 = new Valuta("Doll", 20.00, 10, true);
        val2 = new Valuta("Doll", 20.00, 10, true);
        System.out.println(val1.equals(val2));
    }
}