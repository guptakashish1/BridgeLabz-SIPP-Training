import java.util.Scanner;
public class QuotientAndReminder {
    public static int[] getQuotientAndReminder(int n, int m){
        int[] result = new int[2];
        result[0] = n/m;
        result[1] = n%m;
        return result;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dividend (n): ");
        int n = sc.nextInt();
        System.out.println("Enter the divisior (m): ");
        int m = sc.nextInt();
        int[] result = getQuotientAndReminder(n,m);
        System.out.println("quotient :"+ result[0]);
        System.out.println("remainder : "+ result[1]);
        sc.close();
    }

}
