package Workshop.StreamAPI;
import java.util.*;
public class SortingWithLambda {
   public static void main(String[] args) {
    List<String> names = Arrays.asList("Ravi", " Anu", " Kiran", " Megha");
    //1. Sort by length
    System.out.println("Sorting by length: ");
    names.sort((a, b) -> a.length() - b.length());
names.forEach(System.out::println);
//2. Reverse alphabetical order
System.out.println("\nSorting in reverse alphabetical order: ");
names.sort((a, b) -> b.compareTo(a));
names.forEach(System.out::println);
   }
    }
