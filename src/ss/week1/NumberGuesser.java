package ss.week1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Guess the number ( 1 - 100): ");
        int y = random.nextInt(100);
        while(true) {
            int x = input.nextInt();

            if (x == y) {
                System.out.println("Hurray you guessed it right");
                break;
            } else if (x > y && x - y > 20) {
                System.out.println("you have guessed too high i.e. more than a difference of 20");
            } else if (x > y && x - y <= 20) {
                System.out.println("you are close, you have guessed higher");
            } else if (x < y && y - x <= 20) {
                System.out.println("you are close, you have guessed lower");
            } else {
                System.out.println("you have guessed too low i.e. more than a difference of 20");
            }
        }
    }
}
