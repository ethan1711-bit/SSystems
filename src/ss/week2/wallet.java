package ss.week2;

import java.util.Scanner;

public class wallet {
    public static void main(String[] args){
        DollarsAndCentsCounter wallet = new DollarsAndCentsCounter();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Wallet Menu ---");
            System.out.println("1. View balance");
            System.out.println("2. Add money");
            System.out.println("3. Reset wallet");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("current Balance " + wallet.getDollars() + " $ and " +
                                               wallet.getCents() + " cents.");
                    break;
                case 2:
                    System.out.println("Dollars to add");
                    int dollars = input.nextInt();
                    System.out.println("Cents to add");
                    int cents = input.nextInt();
                    wallet.add(dollars, cents);
                    System.out.println("Money added and updated");
                    break;
                case 3:
                    wallet.reset();
                    System.out.println("wallet reset and updated");
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    input.close();
                    return;

                default: // Invalid input
                    System.out.println("Invalid choice! Please try again.");

            }
        }
    }
}
