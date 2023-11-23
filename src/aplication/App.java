package aplication;

import entities.Reservations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("room number: ");
        int room = sc.nextInt();
        System.out.println("checkIn date dd/MM/yyyy:");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("checkIn date dd/MM/yyyy");
        Date checkOut = sdf.parse(sc.next());
        if (!checkIn.after(checkOut)){
            System.out.println("error in reservation: check-out date must be after check_in;");
        }else {
            Reservations reservations = new Reservations(room,checkIn,checkOut);
            System.out.println("reservation" + reservations);
            System.out.println();
            System.out.println("enter update data: ");
            System.out.println("checkIn date dd/MM/yyyy:");
            checkIn = sdf.parse(sc.next());
            System.out.println("checkIn date dd/MM/yyyy");
            checkOut = sdf.parse(sc.next());
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("error in reservation, reservation dates must be updated to future dates!!");
            }else if (!checkOut.after(checkIn)){
                System.out.println("error in reservation: check-out date must be after check_in;");
            }else {
            reservations.updateDates(checkIn,checkOut);
            System.out.println("reservation" + reservations);
            }
        }

        sc.close();
    }
}
