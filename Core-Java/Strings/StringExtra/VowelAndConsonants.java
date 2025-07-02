package Strings.StringExtra;
import java.util.Scanner;
public class VowelAndConsonants {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String :");
        String input = sc.nextLine().toLowerCase();
int vowel=0;
int consonants = 0;
for(int i =0; i<=input.length();i++){
     char ch = input.charAt(i);
     if(ch >= 'a' && ch <= 'z'){
        if(ch=='a' || ch == 'e' || ch== 'i' || ch=='o'||ch=='u'){
        vowel++;
        }
        else {
             consonants++;
        }
     }
}
System.out.println("Vowels: " + vowel);
        System.out.println("Consonants: " + consonants);
        sc.close();
    }
}





    