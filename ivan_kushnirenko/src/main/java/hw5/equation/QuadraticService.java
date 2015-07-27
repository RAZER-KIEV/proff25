package hw5.equation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by ivan on 27.07.15.
 */
public class QuadraticService {

    private int minA;
    private int maxA;
    private int minB;
    private int maxB;
    private int minC;
    private int maxC;

    private SolutionJDBCManager solutionJDBCManager;

    public QuadraticService() {
        solutionJDBCManager = new SolutionJDBCManager();
    }

    private void getCoefficients() {
        System.out.println("Please, type coefficients like this: '[min_A;max_A],[min_B;max_B],[min_C;max_C] ' :");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gettedInfo = "";
        try {
            gettedInfo = br.readLine();
            if (!gettedInfo.matches("\\[[0-9];[0-9]\\],\\[[0-9];[0-9]\\],\\[[0-9];[0-9]\\]")) {
                throw new IOException();
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        Scanner scanner = new Scanner(gettedInfo);
        scanner.useDelimiter("\\D*");
        minA = Integer.parseInt(scanner.next("\\d"));
        maxA = Integer.parseInt(scanner.next("\\d"));
        minB = Integer.parseInt(scanner.next("\\d"));
        maxB = Integer.parseInt(scanner.next("\\d"));
        minC = Integer.parseInt(scanner.next("\\d"));
        maxC = Integer.parseInt(scanner.next("\\d"));

        if (maxA < minA || maxB < minB || maxC < minC || minA <= 0 || maxA <= 0) {
            throw new IllegalArgumentException();
        }
        if ((maxA - maxA) * (maxB - minB) * (maxC - minC) > 10000) {
            System.out.println("Sorry, to large range.");
        }
    }

    public void createDecision() {
        getCoefficients();
        for (int a = minA; a < maxA + 1; a++) {
            for (int b = minB; b < maxB + 1; b++) {
                for (int c = minC; c < maxC + 1; c++) {
                    solutionJDBCManager.create(new Solution(a, b, c, ((int) (-b + Math.sqrt(b ^ 2 - 4 * a * c)) / (2 * a)), ((int) (-b - Math.sqrt(b ^ 2 - 4 * a * c)) / (2 * a))));
                }
            }
        }
    }

    public static void main(String[] args) {
        new QuadraticService().createDecision();
    }
}

