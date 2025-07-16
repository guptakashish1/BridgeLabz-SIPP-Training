class StudentRecordList{

    static class Student {
        int rollNumber;
        String name;
        int age;
        String grade;
        Student next;

        Student(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Student head;

    // Add at beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Invalid position. Must be >= 1.");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position is out of bounds.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Student with roll number " + rollNumber + " deleted.");
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student with roll number " + rollNumber + " deleted.");
        }
    }

    // Search by roll number
    public void searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student found: Roll Number: " + temp.rollNumber +
                                   ", Name: " + temp.name +
                                   ", Age: " + temp.age +
                                   ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Update grade by roll number
    public void updateGrade(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Updated grade for roll number " + rollNumber + " to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Display all records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber +
                               ", Name: " + temp.name +
                               ", Age: " + temp.age +
                               ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Sample test run
    public static void main(String[] args) {
        StudentRecordList list = new StudentRecordList();

        // Adding records
        list.addAtEnd(101, "Alice", 20, "A");
        list.addAtBeginning(100, "Bob", 19, "B");
        list.addAtPosition(2, 102, "Charlie", 21, "C");
        list.addAtEnd(103, "David", 22, "B+");

        // Display all
        System.out.println("All student records:");
        list.displayAll();

        // Search for a student
        System.out.println("\nSearching for student with roll number 102:");
        list.searchByRollNumber(102);

        // Update grade
        System.out.println("\nUpdating grade for roll number 102:");
        list.updateGrade(102, "A+");

        // Display again
        System.out.println("\nAll student records after grade update:");
        list.displayAll();

        // Delete student
        System.out.println("\nDeleting student with roll number 100:");
        list.deleteByRollNumber(100);

        // Display after deletion
        System.out.println("\nAll student records after deletion:");
        list.displayAll();
    }
}
