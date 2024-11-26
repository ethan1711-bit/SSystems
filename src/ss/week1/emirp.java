package ss.week1;

import java.util.Scanner;

public class emirp {
    /**
     * Checks if a number is emirp
     * A prime number is a number greater than 1 with no other divisor other than the number 1
     * and the number itselfd.
     * @param num is the integer that will be checked.
     * @return true if the number is prime or is false otherwise.
     */
    public static boolean isPrime (int num) {
        //Check if the number is 1 itself or lesser than it.
        if (num <= 1)
            // if it is, it is not prime, hence returns false.
            return false;
        //Check if the number is  2
        if (num == 2)
            // if it is, it is prime, hence returns true.
            return true;
        // checks if the is divisible by 2
        if (num % 2 == 0)
            // if it is, it is not prime, hence returns false.
            return false;
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        // if no divisors are found it should be prime and hence is true.
        return true;
    }
    public static int reverse(int num) {

        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
    public static boolean isEmirp(int num){
        if (!isPrime(num))
            return false;
        if (reverse(num) == num)
            return false;
        return isPrime(reverse(num));
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("How many emrips? ");
        int primesnum = input.nextInt();
        int count = 0;
        for(int num = 2; count < primesnum; num++){
            if(isEmirp(num)){
                System.out.print(num + " ");
                count++;
            }
        }
    }
}
