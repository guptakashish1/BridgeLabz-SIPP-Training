package Encapsulation_Polymorphism_Interface_Abstract_Class;

abstract class LibraryItem {
    String title;
    LibraryItem(String title) { this.title = title; }
    abstract int loanDays();
}

interface Reservable {
    void reserve(String user);
}

class Book extends LibraryItem implements Reservable {
    Book(String title) { super(title); }
    int loanDays() { return 14; }
    public void reserve(String user) { System.out.println(title + " reserved by " + user); }
}

class DVD extends LibraryItem implements Reservable {
    DVD(String title) { super(title); }
    int loanDays() { return 7; }
    public void reserve(String user) { System.out.println(title + " reserved by " + user); }
}

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryItem[] items = { new Book("Java Basics"), new DVD("Inception") };
        for (LibraryItem item : items) {
            ((Reservable)item).reserve("User1");
            System.out.println(item.title + " | Days: " + item.loanDays());
        }
    }
}
