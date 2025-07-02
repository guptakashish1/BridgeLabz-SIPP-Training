package Strings.StringExtra;
import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your String");
        String input = sc.nextLine();
   String result = "";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (result.indexOf(currentChar) == -1) {
                result += currentChar;
            }
        }
        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}
