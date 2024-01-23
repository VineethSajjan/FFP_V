package Audintel.dao;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class TravelInfo {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketId;

    @Column(name = "member_id")
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private int memberId;

    @Column(name = "dest_id")
    @JoinColumn(name = "dest_id", referencedColumnName = "dest_Id")
    private int destId;

    @Column(name = "date")
    private Date date;

    @Column(name = "person_travelling")
    private boolean personTravelling;

    @Column(name = "total_members")
    private int totalMembers;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public boolean isPersonTravelling() {
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

