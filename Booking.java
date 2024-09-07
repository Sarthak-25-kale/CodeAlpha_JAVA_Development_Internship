import java.util.Date;

public class Booking {
    private String bookingID;
    private Room room;
    private String customerName;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalAmount;
    private boolean isPaid;

    public Booking(String bookingID, Room room, String customerName, Date checkInDate, Date checkOutDate) {
        this.bookingID = bookingID;
        this.room = room;
        this.customerName = customerName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateTotalAmount();
        this.isPaid = false;
    }

    private double calculateTotalAmount() {
        long duration = (checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24);
        return duration * room.getPricePerNight();
    }

    public void makePayment() {
        this.isPaid = true;
    }

    // Getters and Setters
    public String getBookingID() {
        return bookingID;
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", room=" + room +
                ", customerName='" + customerName + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalAmount=" + totalAmount +
                ", isPaid=" + isPaid +
                '}';
    }
}
