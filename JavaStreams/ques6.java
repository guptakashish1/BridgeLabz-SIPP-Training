import java.io.*;

public class ques6 {
    public static void main(String[] args) {
        String inputFile = "input.txt";         // Replace with your input file
        String outputFile = "output.txt";       // Output file

        try (
            // Handle encoding explicitly (e.g., UTF-8)
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());  // Convert to lowercase
                writer.newLine(); // preserve line breaks
            }

            System.out.println("File has been converted to lowercase and saved as " + outputFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
