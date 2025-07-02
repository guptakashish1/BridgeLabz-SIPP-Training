public class Employee {
    static String companyName = "OpenAI Technologies";
    static int totalEmployees = 0;
    private String name;
    private String designation;
    private final int id;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public static void displayEmployeeDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            System.out.println("\n--- Employee Details ---");
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + emp.name);
            System.out.println("ID: " + emp.id);
            System.out.println("Designation: " + emp.designation);
        } else {
            System.out.println("The given object is not an Employee instance.");
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob", 102, "Product Manager");
        displayEmployeeDetails(emp1);
        displayEmployeeDetails(emp2);
        String notAnEmployee = "Just a string";
        displayEmployeeDetails(notAnEmployee);
        displayTotalEmployees();
    }
}
