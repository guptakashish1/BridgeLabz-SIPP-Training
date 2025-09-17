 
// You have a list of integer
//Find all the numbers greater than 30 and collect them into a list
package Workshop.StreamAPI;  
import java.util.*;
import java.util.stream.Collectors;

public class FilterAndCollect {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 25, 35, 40, 15, 60 );

        // Filter numbers greater than 30 and collect into a list
        List<Integer> result = numbers.stream()
        .filter(n -> n > 30)   
        .collect(Collectors.toList()); 

        System.out.println("Numbers greater than 30: " + result);
    }
}


