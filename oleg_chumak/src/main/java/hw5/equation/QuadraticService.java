package hw5.equation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 11.06.15.
 */
public class QuadraticService {
    public List<Solution> list = new ArrayList<>();
    private int number = 1;

    public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC){
        if (toA < fromA | toB < fromB | toC < fromC){
            System.out.println("incorrect number parametres");
        } else if (((toA - fromA + 1) * (toB - fromB + 1) * (toC - fromC + 1) > 10000)){
            System.out.println("to much solutions");
        }
        else {
            for (int a = fromA; a <= toA; a++){
                for (int b = fromB; b <= toB; b++){
                    for (int c = fromC; c <= toC; c++){
                        double D = b*b-4*a*c;
                        if (D<0) {}
                        else   if (D==0)  {
                            double  x1 = -b/(2*a);
                            list.add(new Solution(number++, a, b, c, x1, x1));
                        }
                        else {
                            double x1 = (-b + Math.sqrt(D)) / (2 * a);
                            double x2 = (-b - Math.sqrt(D)) / (2 * a);
                            list.add(new Solution(number++, a, b, c, x1, x2));
                        }
                    }
                }
            }
        }
    }
}
