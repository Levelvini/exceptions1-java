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
            String error = reservations.updateDates(checkIn,checkOut);
            if (error!=null){
                System.out.println("reservation error: "+ error);
            }else {
                System.out.println("reservation" + reservations);
            }
        }

        sc.close();
    }
}
