package ss.week1;

import java.util.Scanner;

public class telekeypad {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the word");
        String chr = input.nextLine();
        char[] digits = new char[chr.length()];

        for(int i = 0; i < chr.length(); i++){
            char ch = Character.toUpperCase(chr.charAt(i));
            switch (ch){
                case 'A' : case 'B' : case 'C' :
                    digits[i] = '2';
                    break;
                case 'D': case 'E': case 'F':
                    digits[i] = '3';
                    break;
                case 'G': case 'H': case 'I':
                    digits[i] = '4';
                    break;
                case 'J': case 'K': case 'L':
                    digits[i] = '5';
                    break;
                case 'M': case 'N': case 'O':
                    digits[i] = '6';
                    break;
                case 'P': case 'Q': case 'R': case 'S':
                    digits[i] = '7';
                    break;
                case 'T': case 'U': case 'V':
                    digits[i] = '8';
                    break;
                case 'W': case 'X': case 'Y': case 'Z':
                    digits[i] = '9';
                    break;
                case ' ':
                    digits[i] = 0;
                    break;
                default:
                    digits[i] = ' ';
                    break;
            }
        }
        String res = new String(digits).replaceAll(" ", "");
        System.out.println(res);
    }
}
