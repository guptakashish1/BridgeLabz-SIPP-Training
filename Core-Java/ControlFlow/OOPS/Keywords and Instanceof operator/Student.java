public class Student {
    static String universityName = "OpenAI University";
    static int totalStudents = 0;
    private String name;
    private String grade;
    private final int rollNumber;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public static void displayStudentDetails(Object obj) {
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            System.out.println("\n--- Student Details ---");
            System.out.println("University: " + universityName);
            System.out.println("Name: " + stu.name);
            System.out.println("Roll Number: " + stu.rollNumber);
            System.out.println("Grade: " + stu.grade);
        } else {
            System.out.println("The given object is not a Student instance.");
        }
    }

    public static void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            stu.grade = newGrade;
            System.out.println("Updated grade for " + stu.name + ": " + stu.grade);
        } else {
            System.out.println("The given object is not a Student instance.");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 1, "A");
        Student s2 = new Student("Bob", 2, "B");
        displayStudentDetails(s1);
        displayStudentDetails(s2);
        String notAStudent = "Just a string";
        displayStudentDetails(notAStudent);
        updateGrade(s2, "A+");
        displayTotalStudents();
    }
}
