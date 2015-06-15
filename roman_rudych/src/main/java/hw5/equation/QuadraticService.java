package hw5.equation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 14.06.2015.
 */
public class QuadraticService {

    private List<Solution> list = new ArrayList<>();
    private boolean hasSolution;
    private double result1;
    private double result2;

    public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC) {
        for(int i = fromA; i < toA; i++) {
            for(int j = fromB; j < toB; j++) {
                for (int k = fromC; k < toC; k++) {
                    findResult(i,j,k);
                    if(hasSolution) {
                        list.add(new Solution(i,j,k,result1, result2));
                    }
                }
            }
        }

    }

    private void findResult(int a, int b, int c) {
        if(a==0) {
            result1 = result2 = -c/b;
            hasSolution = true;
        } else if(b == 0 && c == 0) {
            result1 = result2 = 0;
            hasSolution = true;
        } else if(b == 0 && c != 0) {
            if(-c/a > 0) {
                result1 = Math.sqrt(-c/a);
                result2 = - Math.sqrt(-c/a);
                hasSolution = true;
            } else if (-c/a == 0) {
                result1 = result2 = 0;
                hasSolution = true;
            } else {
                hasSolution = false;
            }
        } else {
            int diskr = b * b - 4 * a * c;
            if (diskr >= 0) {
                result1 = (-b + Math.sqrt(diskr) / (2 * a));
                result2 = (-b - Math.sqrt(diskr) / (2 * a));
                hasSolution = true;
            } else {
                hasSolution = false;
            }
        }
    }
    public List<Solution> getList() {
        return list;
    }
}
