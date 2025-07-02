import java.util.Scanner;
public class SubString {
   public static String extractSubstringusingcharAt(String str, int start, int end) {
       String result = "";
       for (int i = start; i < end && i < str.length(); i++) {
           result += str.charAt(i);
       }
       return result;
   }
    public static String extractSubstringusingSubString(String str, int start, int end) {
        if (start < 0 || end > str.length() || start >= end) {
            throw new IllegalArgumentException("Invalid start or end indices");
        }
        return str.substring(start, end);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();
        String charAtSubstring = extractSubstringusingcharAt(input, start, end);
        String substring = extractSubstringusingSubString(input, start, end);
        System.out.println("\nExtracted using charAt(): " + charAtSubstring);
        System.out.println("Extracted using substring(): " + substring);
        boolean isSame = charAtSubstring.equals(substring);
        System.out.println("Both methods yield the same result: " + isSame);
        if (!isSame) {
            System.out.println("Differences found:");
            System.out.println("Using charAt(): " + charAtSubstring);
            System.out.println("Using substring(): " + substring);
        } else {
            System.out.println("Both methods produced the same substring.");
        } 
        scanner.close();      
}

}
