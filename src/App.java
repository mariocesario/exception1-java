import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Chec-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Chec-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println("reservation: " + reservation);

        System.out.println();
        System.out.println("Enter data to update the reservation:");
        System.out.print("Chec-in date (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Chec-out date (dd/MM/yyyy): ");
        checkOut = sdf.parse(sc.next());

        reservation.updateDates(checkIn, checkOut);
        System.out.println("reservation: " + reservation);
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: "+ e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}
