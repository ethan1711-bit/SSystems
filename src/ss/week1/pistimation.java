package ss.week1;

import java.util.Random;
import java.util.Scanner;

public class pistimation {
    public static void main(String[] args) {
        double n = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of iterations: ");
        int N = input.nextInt();
        Random random = new Random();
        for (int i = 0; i <= N; i++) {
            double x = random.nextDouble(1);
            double y = random.nextDouble(1);
            double eq = (x*x) + (y*y);
            if(eq <= 1){
                n++;
            }
        }
        double pi = 4*n/N;
        System.out.println(pi);
    }
}
