package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyy): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date!");

		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/mm/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date!");
			} else {
				reservation.upadaDeates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}

}