package Encapsulation_Polymorphism_Interface_Abstract_Class;

abstract class Patient {
    String name;
    int age;
    Patient(String name, int age) { this.name = name; this.age = age; }
    abstract double bill();
}

interface MedicalRecord {
    void addRecord(String r);
}

class InPatient extends Patient implements MedicalRecord {
    InPatient(String name, int age) { super(name, age); }
    double bill() { return 3000; }
    public void addRecord(String r) { System.out.println("In-Record: " + r); }
}

class OutPatient extends Patient implements MedicalRecord {
    OutPatient(String name, int age) { super(name, age); }
    double bill() { return 500; }
    public void addRecord(String r) { System.out.println("Out-Record: " + r); }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Patient[] p = { new InPatient("Amit", 45), new OutPatient("Rekha", 30) };
        for (Patient patient : p) {
            ((MedicalRecord)patient).addRecord("Checkup Done");
            System.out.println(patient.name + " | Bill: " + patient.bill());
        }
    }
}
