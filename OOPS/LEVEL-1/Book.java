public class Book {

    String title;
    String author;
    double price;

    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Book Title : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : Rs" + price);
    }

    
    public static void main(String[] args) {
       
        Book myBook = new Book("The Alchemist", "Paulo Coelho", 499.50);

        myBook.displayDetails();
    }
}
