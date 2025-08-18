import java.io.*;

public class ques7 {
    public static void main(String[] args) {
        String fileName = "student_data.bin";

        
        int rollNumber = 101;
        String name = "Alice";
        double gpa = 8.75;

        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

       
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int roll = dis.readInt();
            String studentName = dis.readUTF();
            double studentGpa = dis.readDouble();

            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + studentName);
            System.out.println("GPA: " + studentGpa);
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
