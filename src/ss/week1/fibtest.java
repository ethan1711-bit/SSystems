package ss.week1;

import java.util.Scanner;

public class fibtest {
    public static long fibs(int num){
        if (num == 0){
            return num;
        }
        if (num == 1){
            return num;
        }
        return fibs (num-1) + fibs (num - 2);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("At what index would you like to see the fib number? : ");
        int num = input.nextInt();
        System.out.println("The fib number is " + fibs(num)) ;
    }
}
