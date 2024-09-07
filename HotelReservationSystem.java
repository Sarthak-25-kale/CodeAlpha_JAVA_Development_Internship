import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private static Hotel hotel = new Hotel();

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View All Bookings");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();
                    List<Room> availableRooms = hotel.searchAvailableRooms(roomType);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No rooms available for this type.");
                    } else {
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter check-in date (dd-MM-yyyy): ");
                    Date checkInDate = sdf.parse(scanner.nextLine());
                    System.out.print("Enter check-out date (dd-MM-yyyy): ");
                    Date checkOutDate = sdf.parse(scanner.nextLine());

                    Booking booking = hotel.makeReservation(customerName, roomNumber, checkInDate, checkOutDate);
                    if (booking != null) {
                        System.out.println("Reservation successful. Booking details:");
                        System.out.println(booking);
                    } else {
                        System.out.println("Failed to make a reservation. Room may not be available.");
                    }
                    break;
                case 3:
                    List<Booking> bookings = hotel.getAllBookings();
                    for (Booking b : bookings) {
                        System.out.println(b);
                    }
                    break;
                case 4:
                    System.out.print("Enter booking ID: ");
                    String bookingID = scanner.nextLine();
                    Booking bookingDetails = hotel.getBookingDetails(bookingID);
                    if (bookingDetails != null) {
                        System.out.println(bookingDetails);
                    } else {
                        System.out.println("Booking not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
