import java.util.Scanner;
public class MaxHandshakeAmongStudents {
    public static int maxHandshake(int n){
        if(n<2){
            return 0;
        }
return(n*(n*1))/2;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("ENter the Number of Students:");
        int n = sc.nextInt();
        System.out.print("Max Handshakes Among Students:");
        System.out.println(maxHandshake(n));
        sc.close();
    }
}
