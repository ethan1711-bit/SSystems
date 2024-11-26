package ss.week1;

import java.util.Scanner;

public class belastingdienst {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("What is your income? : ");
        Double I = input.nextDouble();
        if(I < 35473) {
            double tax = 0.0942*I;
            System.out.println("Your income tax is " + tax);
        }

        else if (I > 35473 && I < 69399) {
            double tax = 341 + 0.3707*(I - 35472);
            System.out.println("Your income tax is " + tax);
        }

        else {
            double tax = 15917+0.4950*(I-69398);
            System.out.println("Your income tax is " + tax);
        }
    }
}
