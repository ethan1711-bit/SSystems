package ss.week1;

import java.util.Arrays;
import java.util.Scanner;

public class  SplitNumbers {
    public static int[] spliter(String nums){
        String[] split = nums.split("\\s+");
        int[] result = new int[split.length];
        for( int i = 0; i < split.length; i++){
            result[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(result);
        return result;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("enter numbers");
        String nums = input.nextLine();
        System.out.println(Arrays.toString(spliter(nums)));
    }

}
