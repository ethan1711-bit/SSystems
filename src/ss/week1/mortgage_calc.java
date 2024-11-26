package ss.week1;

import java.util.Scanner;

import static java.lang.Math.ceil;

public class mortgage_calc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the yearly interest rate (in %)?");
        double yri = input.nextDouble();
        double r = (yri/12)/100;
        System.out.print("What is the amount borrowed?");
        double P = input.nextDouble();
        System.out.print("What is the number of years?");
        double years = input.nextDouble();
        double N = years*12;
        double Denom = 1-Math.pow(1+r, -N);
        double c = ceil(P*r/ Denom);
        System.out.println(c);
    }
}
