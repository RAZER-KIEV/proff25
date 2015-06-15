package hw5.equation;


public class Solution{
    private int koefA;
    private int koefB;
    private int koefC;
    private double res1;
    private double res2;

    public Solution(int koefA, int koefB, int koefC, double res1, double res2) {
        this.koefA = koefA;
        this.koefB = koefB;
        this.koefC = koefC;
        this.res1 = res1;
        this.res2 = res2;
    }


    public void setKoefA(int koefA) {
        this.koefA = koefA;
    }

    public void setKoefB(int koefB) {
        this.koefB = koefB;
    }

    public void setKoefC(int koefC) {
        this.koefC = koefC;
    }

    public void setRes1(double res1) {
        this.res1 = res1;
    }

    public void setRes2(double res2) {
        this.res2 = res2;
    }

    public int getKoefA() {
        return koefA;
    }

    public int getKoefB() {
        return koefB;
    }

    public int getKoefC() {
        return koefC;
    }

    public double getRes1() {
        return res1;
    }

    public double getRes2() {
        return res2;
    }

    public void print(){
        System.out.println(koefA+" "+koefB+" "+koefC+" "+res1+" "+res2);
    }
}