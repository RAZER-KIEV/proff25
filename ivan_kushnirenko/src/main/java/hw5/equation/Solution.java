package hw5.equation;

/**
 * Created by ivan on 27.07.15.
 */
public class Solution {

    private Long id;

    private int a;
    private int b;
    private int c;

    private int sol1;
    private int sol2;

    public Solution(int a, int b, int c, int sol1, int sol2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.sol1 = sol1;
        this.sol2 = sol2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getSol1() {
        return sol1;
    }

    public void setSol1(int sol1) {
        this.sol1 = sol1;
    }

    public int getSol2() {
        return sol2;
    }

    public void setSol2(int sol2) {
        this.sol2 = sol2;
    }
}
