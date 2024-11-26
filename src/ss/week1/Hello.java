package ss.week1;

import java.util.Scanner;

/**
 * Hello World class.
 */
public class Hello {
    /**
     * Prints a greeting to the console.
     * @param args command-line arguments; currently unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" What is your name?");
        String name = input.nextLine();
        System.out.println(" What is your age?");
        int age = input.nextInt();
        System.out.println("Hello " + name + " " + "you are " + age + " years old");
    }
}

