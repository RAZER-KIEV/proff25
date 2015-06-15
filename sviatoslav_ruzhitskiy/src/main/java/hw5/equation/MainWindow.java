package hw5.equation;

import scala.Int;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by RAZER on 13.06.2015.
 */
public class MainWindow {
  public static void main(String[] args) throws SQLException {
      Locale.setDefault(Locale.UK);

      QuadraticService quadraticService = new QuadraticService();
      quadraticService.solve(1, 1, -8, -8, 1, 12);

      SolutionJDBCManager solutionJDBCManager=new SolutionJDBCManager();
      System.out.println("try to select from DB to ArrayList!");

      ArrayList<Solution> resArryaLst = (ArrayList<Solution>) solutionJDBCManager.findAll();




    }
}
class SolutionJDBCManager{

    ArrayList<Solution> dbImport;

    Statement stmt;
    Solution solution;



    public SolutionJDBCManager() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
            System.out.println(conn);
            stmt = conn.createStatement();
        } catch (SQLException sqlEx)  { sqlEx.printStackTrace();  }


    }

    public int create(Solution solution) throws SQLException {

        this.solution = solution;
        int id = solution.getId();
        int constA = solution.getConstA();
        int constB = solution.getConstB();
        int constC = solution.getConstC();
        double x1 = solution.getX1();
        double x2 =solution.getX2();
        StringBuilder sb =new StringBuilder();
        sb.append("INSERT INTO solutions VALUES(" + id + "," + constA + "," + constB + "," + constC + "," + x1 + "," + x2 + ")");
        System.out.println(sb.toString());
        String sqlReq =sb.toString();
        int res = stmt.executeUpdate(sqlReq);

        return res;
    }
    public List<Solution> findAll() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        System.out.println(conn);
        stmt = conn.createStatement();

        ArrayList<Solution> dbImport = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT * FROM solutions");



        boolean rsnxt = rs.next();
        while (rsnxt){
            int id = rs.getInt(1);
            System.out.print("id:  " + id + ",  ");

            int constA = rs.getInt(2);
            System.out.print("Const A: " + constA + ",  ");

            int constB = rs.getInt(3);
            System.out.print("Const B: " + constB + ",  ");

            int constC = rs.getInt(4);
            System.out.print("Const C: " + constC + ",  ");

            double x1 = rs.getDouble(5);
            System.out.print("X1: " + x1 + ", ");

            double x2 = rs.getDouble(6);
            System.out.println("X2: " + x2 +", ");

            Solution tmp = new Solution(id,constA,constB,constC,x1,x2);
            dbImport.add(tmp);

            rsnxt= rs.next();

        }

       return  dbImport;
    }
}
class Solution{
    private int id;
    private int constA;
    private int constB;
    private int constC;
    private double x1;
    private double x2;

    public int getId(){return id;}
    public int getConstA(){return constA;}
    public int getConstB(){return constB;}
    public int getConstC(){return constC;}
    public double getX1(){return x1;}
    public double getX2(){return x2;}

    Solution(int id,int constA,int constB,int constC, double x1, double x2){
        this.id = id;
        this.constA = constA;
        this.constB = constB;
        this.constC = constC;
        this.x1 = x1;
        this.x2 = x2;

    }

}
class QuadraticService{
   private  ArrayList<Solution> solArrLst;
    public ArrayList<Solution> getSolArrLst(){
        return solArrLst;
    }
    //Dano:
    int constABigin, constAEnd;
    int constBBigin, constBEnd;
    int constCBigin, constCEnd;

    //solution:
    double x1;
    double x2;
    double desc;

    public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC) throws SQLException {
        int solCout =1;
        ArrayList<Solution> solArrLst = new ArrayList<>();
        SolutionJDBCManager solutionJDBCManager = new SolutionJDBCManager();

    if (fromA!=0) {

        for (int a = fromA; a <= toA; a++) {
          for (int b = fromB; b <= toB; b++) {
            for (int c = fromC; c <= toC; c++) {
                if(solCout<10000) {
                    //desc culc:
                    desc = (Math.pow(b, 2) - 4 * a * c);
                    if (desc > 0) {
                        //X1 culc:
                        x1 = (-b + Math.sqrt(desc)) / (2 * a);
                        //X2 culc:
                        x2 = (-b - Math.sqrt(desc)) / (2 * a);
                        System.out.println("Get Solution!: id = " +solCout +", a= " + a + ", b = " + b + ", c = " + c + ", x1 = " + x1 + ", x2 = " + x2);
                        Solution tmp = new Solution(solCout,a, b, c, x1, x2);
                        solArrLst.add(tmp);
                        solutionJDBCManager.create(tmp);
                        solCout++;

                    }
                    if (desc == 0) {
                        x1 = x2 = (-b / 2 * a);
                        Solution tmp = new Solution(solCout,a, b, c, x1, x2);
                        solArrLst.add(tmp);
                        System.out.println("Get Solution!: id= "+solCout+", a = " + a + ", b = " + b + ", c = " + c + ", x1 = " + x1 + ", x2 = " + x2);
                        solutionJDBCManager.create(tmp);
                        solCout++;
                    }
                    if (desc < 0) {
                        System.out.println("No real solutions!");
                    }
                }else {
                    System.out.println("It's very large diapason!");
                }
            }
          }this.solArrLst = solArrLst;

            break;
        }
     }




    }

    public void setBoundariesAndSolve() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Equation:  Ax2 + Bx + C = 0 ");
            System.out.println("Set const A Bigin: ");
            constABigin = Integer.parseInt(in.nextLine());
            System.out.println("Set const A End: ");
            constAEnd = Integer.parseInt(in.nextLine());
            System.out.println("Set const B Bigin: ");
            constBBigin = Integer.parseInt(in.nextLine());
            System.out.println("Set const B End: ");
            constBEnd = Integer.parseInt(in.nextLine());
            System.out.println("Set const C Bigin: ");
            constCBigin = Integer.parseInt(in.nextLine());
            System.out.println("Set const C End: ");
            constCEnd = Integer.parseInt(in.nextLine());

            solve(constABigin, constAEnd,constBBigin, constBEnd,constCBigin, constCEnd);

         }catch (Exception ex){
            System.out.println("SET digits only, newB!");
            ex.printStackTrace();
         }
    }
}