package Encapsulation_Polymorphism_Interface_Abstract_Class;
abstract class Employee {
    private String name;
    Employee(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract double calculateSalary();
}

interface Department {
    void assignDept(String dept);
    String getDept();
}

class FullTimeEmployee extends Employee implements Department {
    private double fixedSalary;
    private String dept;
    FullTimeEmployee(String name, double salary) {
        super(name);
        this.fixedSalary = salary;
    }
    public double calculateSalary() { return fixedSalary; }
    public void assignDept(String dept) { this.dept = dept; }
    public String getDept() { return dept; }
}

class PartTimeEmployee extends Employee implements Department {
    private int hours;
    private double rate;
    private String dept;
    PartTimeEmployee(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    public double calculateSalary() { return hours * rate; }
    public void assignDept(String dept) { this.dept = dept; }
    public String getDept() { return dept; }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Alice", 50000);
        Employee e2 = new PartTimeEmployee("Bob", 60, 200);

        ((Department) e1).assignDept("HR");
        ((Department) e2).assignDept("Support");

        for (Employee e : new Employee[]{e1, e2}) {
            System.out.println(e.getName() + " | Salary: " + e.calculateSalary() +
                " | Dept: " + ((Department) e).getDept());
        }
    }
}
