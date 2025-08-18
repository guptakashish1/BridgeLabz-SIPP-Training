import java.io.*;

public class ques2 {
    public static void main(String[] args) {
        String sourcePath = "largefile.dat";         
        String destUnbuffered = "unbuffered_copy.dat";
        String destBuffered = "buffered_copy.dat";

        // Unbuffered copy
        long startUnbuffered = System.nanoTime();
        copyUnbuffered(sourcePath, destUnbuffered);
        long endUnbuffered = System.nanoTime();

        // Buffered copy
        long startBuffered = System.nanoTime();
        copyBuffered(sourcePath, destBuffered);
        long endBuffered = System.nanoTime();

        System.out.println("Unbuffered Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
        System.out.println("Buffered Time:   " + (endBuffered - startBuffered) / 1_000_000 + " ms");
    }

    // Method using unbuffered streams
    public static void copyUnbuffered(String src, String dest) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[4096];             int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        }
    }

    public static void copyBuffered(String src, String dest) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096]; 
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        }
    }
}
