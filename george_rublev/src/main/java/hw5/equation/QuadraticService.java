package hw5.equation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 11.06.15.
 */
public class QuadraticService {
    public List<Solution> data = new ArrayList<Solution>();

    SolutionJDBCManager base = new SolutionJDBCManager();
    public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC){

        for (int startA = fromA; startA <= toA; startA++){

            for(int startB = fromB; startB <= toB; startB++){

                for(int startC = fromC; startC <= toC; startC++){

                    double d = (Math.pow(startB,2))-(4*startA*startC);
                    double x1 = 0;
                    double x2 = 0;
                    if(d>=0){
                        x1 = (-startB+(Math.sqrt(d))) / (2*startA);
                        x2 = (-startB-(Math.sqrt(d))) / (2*startA);
                    }
                    data.add(new Solution(startA,startB,startC,x1,x2));
                    System.out.println("added to list: " + startA +"  "+startB+"  "+startC+ "  "+x1+"  "+x2);
//                    base.create(new Solution(startA,startB,startC,x1,x2));
                }
            }
        }

        if(data.size()>10000){
            System.out.println("Too much solutions!");
        }else{
            for (Solution solution: data){
                base.create(solution);
                System.out.println("added to base: " + solution.getA() +"  "+solution.getB()+"   "+ solution.getC()+ "  "+solution.getX1()+"  "+solution.getX2());
            }
        }
    }

    public void printAll(){
        data = base.findAll();
//        System.out.println(data);
        for(Solution sol : data){
            System.out.println("from base: A = "+sol.getA()+", B = "+sol.getB()+
                    ", C = "+ sol.getC()+", X1 = "+sol.getX1()+ ", X2 = "+sol.getX2());
        }
    }
}
