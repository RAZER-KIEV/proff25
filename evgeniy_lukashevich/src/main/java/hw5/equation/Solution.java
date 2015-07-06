package hw5.equation;

import java.util.ArrayList;

/**
 * Created by Jeckgehor on 30.06.2015.
 */
class Solution {
    public static ArrayList<Double> solve(int fromA, int toA, int fromB, int toB, int fromC, int toC) {
        double[] tmp;
        ArrayList<Double> arl = new ArrayList<Double>();
        for (int i = fromA; i <= toA; i++){
            for (int j = fromB; j <= toB; j++) {
                for (int k = fromC; k <= toC; k++) {
                    if (arl.size() > 50_000) {
                        arl.clear();
                        System.out.println("Veri big diapazone");
                        break;
                    }
                    tmp = QuadraticService.equation(i, j, k);
                    if (!((tmp[0] == tmp[1] && tmp[0] == 0) || i == 0 )) {
                        arl.add((double)i);
                        arl.add((double)j);
                        arl.add((double)k);
                        arl.add(tmp[0]);
                        arl.add(tmp[1]);
                    }
                }
            }
        }
        return arl;
    }
}
