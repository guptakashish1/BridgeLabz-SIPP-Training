import java.util.Scanner;
public class Studentvote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]ages = new int[10];
for(int i=0; i < ages.length; i++){
    ages[i] = sc.nextInt();
    for(i=0; i < ages.length; i++){
if(ages[i]<0){
    System.out.println("Invalid age");
}
else if(ages[i]>=18){
    System.out.println("You can vote :"+ages[i]);

}
else{
    System.out.println("You cannot vote:"+ ages[i]);
}
    }
  sc.close();  
}

}
}









        