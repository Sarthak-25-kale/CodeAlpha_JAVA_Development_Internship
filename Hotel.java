import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Hotel {
    private List<Room> rooms;
    private List<Booking> bookings;

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        loadRooms();
    }

    private void loadRooms() {
        rooms.add(new Room("101", "Single", 100.00));
        rooms.add(new Room("102", "Double", 150.00));
        rooms.add(new Room("103", "Suite", 250.00));
    }

    public List<Room> searchAvailableRooms(String roomType) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Booking makeReservation(String customerName, String roomNumber, Date checkIn, Date checkOut) {
        Room room = getRoomByNumber(roomNumber);
        if (room == null || !room.isAvailable()) {
            return null;
        }

        room.setAvailable(false);
        String bookingID = generateBookingID();
        Booking booking = new Booking(bookingID, room, customerName, checkIn, checkOut);
        bookings.add(booking);
        return booking;
    }

    private Room getRoomByNumber(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    private String generateBookingID() {
        return "BOOK" + new Random().nextInt(10000);
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public Booking getBookingDetails(String bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID().equals(bookingID)) {
                return booking;
            }
        }
        return null;
    }
}
