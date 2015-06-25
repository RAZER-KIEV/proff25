package hw5.equation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class QuadraticService {
    static ArrayList<Solution> listSolutions;
    public QuadraticService(){
        listSolutions = new ArrayList<>();
    }
    public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC){
        int countSolutions = 0;
        System.out.println("solve");
        Integer D = null;
        for (int posA = fromA; posA < toA; posA++){
            for (int posB = fromB; posB < toB; posB++){
                for (int posC = fromC; posC < toC; posC++){
                    D = (posB*posB) - (4 * posA * posC);
                    if (D >= 0){
                        countSolutions++;
                        if (countSolutions > 10000){
                            System.out.println("Слишком большой диапазон");
                            listSolutions.clear();
                            return;
                        }
                        Double x1 = null;
                        Double x2 = null;
                        x1 = ( ((-posB) + Math.sqrt((double)D)) / (2*posA) );
                        if (D > 0){
                            x2 = ( ((-posB) - Math.sqrt((double)D)) / (2*posA) );
                        }
                        if (x1 != null){
                            x1 = new BigDecimal(x1).setScale(3, RoundingMode.UP).doubleValue();
                        }
                        if (x2 != null){
                            x2 = new BigDecimal(x2).setScale(3, RoundingMode.UP).doubleValue();
                        }
                        listSolutions.add(new Solution(posA, posB, posC, D, x1, x2));
                    }
                }
            }
        }
        System.out.println("count solutions = " + listSolutions.size());
        SolutionJDBCManager solutionJDBCManager = new SolutionJDBCManager();
        solutionJDBCManager.connect();
        for (Solution sol : listSolutions ){
            System.out.println(sol.toString());
            solutionJDBCManager.create(sol);
        }
        solutionJDBCManager.close();
    }
}

