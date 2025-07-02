public class Patient {
    static String hospitalName = "OpenAI Hospital";
    static int totalPatients = 0;
    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public static void displayPatientDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            System.out.println("\n--- Patient Details ---");
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
            System.out.println("Patient ID: " + p.patientID);
        } else {
            System.out.println("The given object is not a Patient instance.");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Flu", 1001);
        Patient p2 = new Patient("Bob", 45, "Fracture", 1002);
        displayPatientDetails(p1);
        displayPatientDetails(p2);
        String notAPatient = "Just a string";
        displayPatientDetails(notAPatient);
        getTotalPatients();
    }
}
