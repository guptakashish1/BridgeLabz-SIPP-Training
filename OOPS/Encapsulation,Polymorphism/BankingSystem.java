package Encapsulation_Polymorphism_Interface_Abstract_Class;

abstract class BankAccount {
    String name;
    double balance;
    BankAccount(String name, double balance) { this.name = name; this.balance = balance; }
    abstract double interest();
}

interface Loanable {
    boolean eligible();
}

class SavingsAccount extends BankAccount implements Loanable {
    SavingsAccount(String name, double bal) { super(name, bal); }
    double interest() { return balance * 0.04; }
    public boolean eligible() { return balance >= 10000; }
}

class CurrentAccount extends BankAccount implements Loanable {
    CurrentAccount(String name, double bal) { super(name, bal); }
    double interest() { return balance * 0.02; }
    public boolean eligible() { return balance >= 20000; }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accs = {
            new SavingsAccount("Ravi", 12000),
            new CurrentAccount("Neha", 25000)
        };
        for (BankAccount acc : accs) {
            System.out.println(acc.name + " | Interest: " + acc.interest() + " | Loan Eligible: " + ((Loanable)acc).eligible());
        }
    }
}
