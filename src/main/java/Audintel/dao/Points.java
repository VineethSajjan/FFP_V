package Audintel.dao;
import jakarta.persistence.*;
@Entity
public class Points {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "points_id")
    private int pointsId;


    @Column(name = "member_id")
    private int memberId;

    @Column(name = "ticket_id")
    private int ticketId;

    @Column(name = "points")
    private int points;
    public int getPointsId() {
        return pointsId;
    }

    public void setPointsId(int pointsId) {
        this.pointsId = pointsId;
    }

    public int getMember() {
        return memberId;
    }

    public void setMember(int memberId) {
        this.memberId = memberId;
    }

    public int getTravelInfo() {
        return ticketId;
    }

    public void setTravelInfo(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
