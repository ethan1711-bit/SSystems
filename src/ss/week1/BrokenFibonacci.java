package ss.week1;

import java.util.Scanner;

public class BrokenFibonacci {
    /**
     * Calculates the nth number in the fibonacci sequence
     * using arrays to store every number.
     * @param n the index of the nth number in the sequence
     * @return the nth fibonacci number
     */

    public static long fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            long[] array = new long[n+1];
            array[0] = 0;
            array[1] = 1;
            for (int i = 2; i <=n; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
            return array[n];
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Index? : ");
        int num = input.nextInt();
        System.out.println("fib number for index " + num + " is " + fibonacci(num));
    }
}
