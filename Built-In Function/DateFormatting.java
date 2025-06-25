import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatting {
  public static void main(String []args){
    LocalDate currentDate = LocalDate.now();
    
    DateTimeFormatter format1 = DateTimeFormatter. ofPattern("dd/MM/YYYY");
     DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        
        String formatted1 = currentDate.format(format1);
        String formatted2 = currentDate.format(format2);
        String formatted3 = currentDate.format(format3);

        
        System.out.println("Format 1 (dd/MM/yyyy): " + formatted1);
        System.out.println("Format 2 (yyyy-MM-dd): " + formatted2);
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + formatted3);
    }
  }  













       


