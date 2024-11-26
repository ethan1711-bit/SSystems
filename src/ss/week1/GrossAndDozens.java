package ss.week1;

import java.util.Scanner;

public class GrossAndDozens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many eggs do you have?");
        int eggs = input.nextInt();
        int gross = eggs/144;
        int dozen = (eggs%144)/12;
        int leftover = (eggs%144)%12;
        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + leftover);
    }
}
