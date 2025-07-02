public class HotelBookingSystem {
    String guestName;
    String roomType;
   int nights;
   //parameterized Constructor
   public HotelBookingSystem(String guestName, String roomType, int nights){
this.guestName = guestName;
this.roomType= roomType;
this.nights= nights;
   }
   //default Constructor
   public HotelBookingSystem(){
    guestName = "Unknown";
    roomType = "Standard";
    nights = 1;

   }
   // Copy Constructor
    public HotelBookingSystem(HotelBookingSystem other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }
   public void displayBookingSystem(){
System.out.println("GuestName :"+ guestName);
System.out.println("RoomType :"+ roomType);
System.out.println("Nights :"+nights);
   }
   public static void main(String[]args){

    HotelBookingSystem booking1 = new HotelBookingSystem();
    System.out.println("Booking 1 (Default Constructor):");
        booking1.displayBookingSystem();

        HotelBookingSystem booking2 = new HotelBookingSystem();
System.out.println("Booking2 (Parameterized Constructor):");
booking2.displayBookingSystem();

HotelBookingSystem booking3 = new HotelBookingSystem(booking2);
        System.out.println("Booking 3 (Copy Constructor from Booking 2):");
        booking3.displayBookingSystem();
   }
}
