package hw5.equation;

/**
 * Created by Jeckgehor on 30.06.2015.
 */
class QuadraticService  {
    public static double[] equation(int coefA, int coefB, int coefC) {
        double[] roots = new double[2];
        double discrym = Math.pow(coefB, 2) - 4 * coefA * coefC;
        if (discrym > 0 && coefA != 0) {
            roots[0] = (-coefB + Math.sqrt(discrym)) / (2 * coefA);
            roots[1] = (-coefB - Math.sqrt(discrym)) / (2 * coefA);
        } else if (discrym == 0 && coefA != 0) {
            roots[0] = roots[1] = -coefB / (2 * coefA);
        }
        return roots;
    }
}
