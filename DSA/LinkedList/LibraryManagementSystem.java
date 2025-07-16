class BookNode {
    String title, author, genre, status;
    int id;
    BookNode next, prev;

    public BookNode(String title, String author, String genre, int id, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.status = status;
        this.next = this.prev = null;
    }
}

class Library {
    private BookNode head;

    // Add book at position (if position <= 1 adds at start, if position > count adds at end)
    public void addBook(String title, String author, String genre, int id, String status, int position) {
        BookNode newNode = new BookNode(title, author, genre, id, status);
        if (head == null || position == 1) {
            if (head != null) head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }
        BookNode temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove book by ID
    public void removeBook(int bookId) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.id == bookId) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                System.out.println("Book ID " + bookId + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID " + bookId + " not found.");
    }

    // Search by Title or Author
    public void searchBook(String key) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key)) {
                System.out.println("ID: " + temp.id + " | Title: " + temp.title + " | Author: " + temp.author +
                                   " | Genre: " + temp.genre + " | Status: " + temp.status);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found.");
    }

    // Update Availability Status
    public void updateStatus(int bookId, String newStatus) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.id == bookId) {
                temp.status = newStatus;
                System.out.println("Status updated for Book ID " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID " + bookId + " not found.");
    }

    // Display all books forward
    public void displayForward() {
        BookNode temp = head;
        if (temp == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Books in Library (Forward):");
        while (temp != null) {
            System.out.println("ID: " + temp.id + " | Title: " + temp.title + " | Author: " + temp.author + " | Status: " + temp.status);
            temp = temp.next;
        }
    }

    // Display all books reverse
    public void displayReverse() {
        BookNode temp = head;
        if (temp == null) {
            System.out.println("Library is empty.");
            return;
        }
        while (temp.next != null) temp = temp.next;  // Go to last node
        System.out.println("Books in Library (Reverse):");
        while (temp != null) {
            System.out.println("ID: " + temp.id + " | Title: " + temp.title + " | Author: " + temp.author + " | Status: " + temp.status);
            temp = temp.prev;
        }
    }

    // Count total books
    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("Book A", "Author X", "Fiction", 1, "Available", 1);
        lib.addBook("Book B", "Author Y", "Science", 2, "Issued", 1);
        lib.addBook("Book C", "Author Z", "History", 3, "Available", 3);

        lib.displayForward();
        System.out.println();
        lib.displayReverse();
        System.out.println();

        lib.searchBook("Author Y");
        lib.updateStatus(2, "Available");

        lib.removeBook(1);
        lib.countBooks();
        lib.displayForward();
    }
}
