import java.io.*;
import java.util.Arrays;

public class ques5 {
    public static void main(String[] args) {
        String originalImagePath = "original.jpg";   
        String newImagePath = "copy.jpg";

        try {
            
            byte[] imageBytes = readImageToByteArray(originalImagePath);

           
            writeByteArrayToImage(imageBytes, newImagePath);

            
            boolean isIdentical = verifyFiles(originalImagePath, newImagePath);
            System.out.println("Files are identical: " + isIdentical);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    
    public static byte[] readImageToByteArray(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }

        fis.close();
        return baos.toByteArray();
    }

    
    public static void writeByteArrayToImage(byte[] data, String path) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        FileOutputStream fos = new FileOutputStream(path);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = bais.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        bais.close();
        fos.close();
    }

    
    public static boolean verifyFiles(String file1, String file2) throws IOException {
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        byte[] buffer1 = new byte[4096];
        byte[] buffer2 = new byte[4096];

        int bytesRead1, bytesRead2;

        while ((bytesRead1 = fis1.read(buffer1)) != -1) {
            bytesRead2 = fis2.read(buffer2);

            if (bytesRead1 != bytesRead2 || !Arrays.equals(buffer1, buffer2)) {
                fis1.close();
                fis2.close();
                return false;
            }
        }

       
        boolean extraBytes = fis2.read() != -1;

        fis1.close();
        fis2.close();
        return !extraBytes;
    }
}
