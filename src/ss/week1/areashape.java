package ss.week1;

import java.util.Scanner;

import static java.lang.Math.atan;

public class areashape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Number of sides? ");
        double n = input.nextDouble();
        System.out.println("Length of each side? ");
        double s = input.nextDouble();
        double denom = (4 * (Math.tan(Math.PI / n)));
        double area = (n * (s * s)) / denom;
        System.out.println(" The area is: " + area);
    }
}
