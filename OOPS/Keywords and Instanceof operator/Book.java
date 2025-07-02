public class Book {
    static String libraryName = "OpenAI Central Library";
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public static void displayBookDetails(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            System.out.println("\n--- Book Details ---");
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
        } else {
            System.out.println("The given object is not a Book instance.");
        }
    }

    public static void main(String[] args) {
        displayLibraryName();
        Book book1 = new Book("1984", "George Orwell", "978-0451524935");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
        displayBookDetails(book1);
        displayBookDetails(book2);
        String notABook = "Just a string";
        displayBookDetails(notABook);
    }
}
