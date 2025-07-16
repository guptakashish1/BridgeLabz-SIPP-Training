class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode current = head;
        int index = 0;
        while (current.next != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            MovieNode newNode = new MovieNode(title, director, year, rating);
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public boolean removeByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    public void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    public void displayForward() {
        MovieNode current = head;
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    public boolean updateRatingByTitle(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void printMovie(MovieNode m) {
        System.out.println(m.title + " | " + m.director + " | " + m.year + " | Rating: " + m.rating);
    }
}
