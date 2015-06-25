package hw5.equation;

public class Solution {
    int coefA;
    int coefB;
    int coefC;
    int D;
    Double x1 = null;
    Double x2 = null;
    Solution(int coefA, int coefB, int coefC, int D, Double x1, Double x2){
        this.coefA = coefA;
        this.coefB = coefB;
        this.coefC = coefC;
        this.D = D;
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return new String("coefA = " + coefA + ", coefB = " + coefB + ", coefC = " + coefC + ", D = " + D + ", x1 = " + x1 + ", x2 = " + x2);
    }
}

