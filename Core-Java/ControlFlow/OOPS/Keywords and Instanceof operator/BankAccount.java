public class BankAccount {

    static String bankName = "State Bank of Java";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Total accounts created: " + totalAccounts);
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: ₹" + balance);
        } else {
            System.out.println("Invalid account object.");
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", "ACC123", 5000.0);
        BankAccount acc2 = new BankAccount("Bob", "ACC456", 7500.0);

        acc1.displayDetails();
        System.out.println("--------------------");
        acc2.displayDetails();

        BankAccount.getTotalAccounts();
    }
}
