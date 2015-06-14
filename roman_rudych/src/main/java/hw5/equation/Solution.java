package hw5.equation;

/**
 * Created by Роман on 14.06.2015.
 */
public class Solution {
    private int coefA;
    private  int coefB;
    private int coefC;
    private double resultOne;
    private double resultTwo;

    public Solution(int coefA, int coefB, int coefC, double resultOne, double resultTwo) {
        this.coefA = coefA;
        this.coefB = coefB;
        this.coefC = coefC;
        this.resultOne = resultOne;
        this.resultTwo = resultTwo;
    }

    public int getCoefA() {
        return this.coefA;
    }
    public int getCoefB() {
        return this.coefB;
    }
    public int getCoefC() {
        return this.coefC;
    }
    public double getResultOne() {
        return this.resultOne;
    }
    public double getResultTwo() {
        return this.resultTwo;
    }
    public String toString() {
        return coefA + "x2 + " + coefB + "x + " + coefC + " = 0\n" + "x1 = " + resultOne + "\n" + "x2 = " + resultTwo;
    }
}
