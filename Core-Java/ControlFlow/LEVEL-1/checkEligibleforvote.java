import java.util.Scanner;
public class checkEligibleforvote {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter your age");
        int age = sc.nextInt();
        if(age==18){
            System.out.println("The person can vote:"+ age);
        }
        else {
            System.out.println("The person cannot vote: "+age);
        }
        sc.close();
    }
}
