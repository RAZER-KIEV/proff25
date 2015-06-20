package hw5.equation;

/**
 * Created by george on 11.06.15.
 */
public class Solution {
    private int a;
    private int b;
    private int c;
    private double x1;
    private  double x2;

    public Solution(int a, int b, int c, double x1, double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x1=x1;
        this.x2=x2;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }
}
