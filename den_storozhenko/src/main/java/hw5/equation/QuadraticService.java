package hw5.equation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by storo_000 on 11.06.2015.
 */
public class QuadraticService {
    List<Solution> solutionList;


    public QuadraticService() {
        solutionList = new ArrayList<>();
    }

    public List<Solution> getSolutionList() {
        return solutionList;
    }

    public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC){
        Solution solution;
        a:for (int i=fromA;i<toA;i++){
            for (int j=fromB;j<toB;j++) {
                for (int k = fromC; k < toC; k++) {
                    if (solutionList.size()>10000) {
                        break a;
                    }
                    solution = solving(i,j,k);
                    if (solution!= null) {
                        solutionList.add(solution);
                        solution.print();
                    }
                }
            }
        }
    }

    public Solution solving(int koefA, int koefB, int koefC){
        double disk = Math.pow(koefB,2)-4*koefA*koefC;
        double res1;
        double res2;
        if (disk>=0) {
            res1 = (-koefB + Math.sqrt(disk)) / 2 / koefA;
            res2 = (-koefB - Math.sqrt(disk)) / 2 / koefA;
            return new Solution(koefA,koefB,koefC,res1,res2);
        }
        return null;
    }
}
