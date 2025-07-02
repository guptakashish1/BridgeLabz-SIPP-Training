public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    public LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } else {
            System.out.println("Sorry, \"" + title + "\" is currently unavailable.");
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        LibraryBook b1 = new LibraryBook("Atomic Habits", "James Clear", 350.0, true);

        System.out.println("Book Details:");
        b1.displayDetails();

        b1.borrowBook();
        b1.displayDetails();

        b1.borrowBook();  
    }
}
