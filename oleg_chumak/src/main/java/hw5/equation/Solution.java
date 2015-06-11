package hw5.equation;

/**
 * Created by oleg on 11.06.15.
 */
public class Solution {
    private int id;
    private int koef_a;
    private int koef_b;
    private int koef_c;
    private double res_1;
    private double res_2;

    public Solution(int id, int koef_a, int koef_b, int koef_c, double res_1, double res_2) {
        this.id = id;
        this.koef_a = koef_a;
        this.koef_b = koef_b;
        this.koef_c = koef_c;
        this.res_1 = res_1;
        this.res_2 = res_2;
    }

    public int getId() {
        return id;
    }

    public int getKoef_a() {
        return koef_a;
    }

    public int getKoef_b() {
        return koef_b;
    }

    public int getKoef_c() {
        return koef_c;
    }

    public double getRes_1() {
        return res_1;
    }

    public double getRes_2() {
        return res_2;
    }
}
