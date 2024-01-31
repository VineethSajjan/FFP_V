package Audintel.dao;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @Column(name = "Booking_id")
    private int bookingId;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "dest_id")
    private int destId;

    @Column(name = "date")
    private Date date;

    @Column(name = "person_travelling")
    private boolean personTravelling;

    @Column(name = "total_members")
    private int totalMembers;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getPersonTravelling() {
        return personTravelling;
    }

    public void setPersonTravelling(boolean personTravelling) {
        this.personTravelling = personTravelling;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
}


