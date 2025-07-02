public class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    public MovieTicket() {
        this.isBooked = false;
    }

    public void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked successfully.");
        } else {
            System.out.println("Ticket already booked.");
        }
    }

    public void displayTicketDetails() {
        if (isBooked) {
            System.out.println("Movie Name  : " + movieName);
            System.out.println("Seat Number : " + seatNumber);
            System.out.println("Price       : ₹" + price);
        } else {
            System.out.println("No ticket has been booked yet.");
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();

        ticket.displayTicketDetails();

        ticket.bookTicket("Interstellar", "A10", 250.00);
        ticket.displayTicketDetails();

        ticket.bookTicket("Inception", "B5", 300.00);  
    }
}
