package hw5.equation;

/**
 * Created by Sveta on 6/13/2015.
 */
public class Solution {
    private int coefficient_a;
    private int coefficient_b;
    private int coefficient_c;
    private double root_1;
    private double root_2;

    public Solution() {
    }

    public Solution(int coefficient_a, int coefficient_b, int coefficient_c, double root_1, double root_2) {
        this.coefficient_a = coefficient_a;
        this.coefficient_b = coefficient_b;
        this.coefficient_c = coefficient_c;
        this.root_1 = root_1;
        this.root_2 = root_2;
    }

    public int getCoefficient_a() {
        return coefficient_a;
    }

    public void setCoefficient_a(int coefficient_a) {
        this.coefficient_a = coefficient_a;
    }

    public int getCoefficient_b() {
        return coefficient_b;
    }

    public void setCoefficient_b(int coefficient_b) {
        this.coefficient_b = coefficient_b;
    }

    public int getCoefficient_c() {
        return coefficient_c;
    }

    public void setCoefficient_c(int coefficient_c) {
        this.coefficient_c = coefficient_c;
    }

    public double getRoot_1() {
        return root_1;
    }

    public void setRoot_1(int root_1) {
        this.root_1 = root_1;
    }

    public double getRoot_2() {
        return root_2;
    }

    public void setRoot_2(int root_2) {
        this.root_2 = root_2;
    }
}
