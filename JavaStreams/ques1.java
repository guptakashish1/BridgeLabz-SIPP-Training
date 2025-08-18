import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class ques1 {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destinationPath = "destination.txt";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            File sourceFile = new File(sourcePath);

            // Check if source file exists
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist: " + sourcePath);
                return;
            }

            // Open input and output streams
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationPath);

            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                outputStream.write(byteData);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while copying the file: " + e.getMessage());
        } finally {
            // Close streams in finally block to ensure they are closed
            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                System.out.println("Error closing the streams: " + e.getMessage());
            }
        }
    }
}
