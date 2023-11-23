package aplication;

import model.entities.Reservations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("room number: ");
            int room = sc.nextInt();
            System.out.println("checkIn date dd/MM/yyyy:");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("checkIn date dd/MM/yyyy");
            Date checkOut = sdf.parse(sc.next());

            Reservations reservations = new Reservations(room, checkIn, checkOut);
            System.out.println("reservation" + reservations);
            System.out.println();
            System.out.println("enter update data: ");
            System.out.println("checkIn date dd/MM/yyyy:");
            checkIn = sdf.parse(sc.next());
            System.out.println("checkIn date dd/MM/yyyy");
            checkOut = sdf.parse(sc.next());
            reservations.updateDates(checkIn, checkOut);
            System.out.println("reservation" + reservations);
        }catch (ParseException e){
            System.out.println("invalid date format:");
        }catch (IllegalArgumentException e){
            System.out.println("error in reservation: "+ e);
        }

        sc.close();
    }
}
