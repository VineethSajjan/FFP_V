package Audintel.dao;
import jakarta.persistence.*;
@Entity
public class Points {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "points_id")
    private int pointsId;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private TravelInfo travelInfo;

    @Column(name = "points")
    private int points;
    public int getPointsId() {
        return pointsId;
    }

    public void setPointsId(int pointsId) {
        this.pointsId = pointsId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public TravelInfo getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(TravelInfo travelInfo) {
        this.travelInfo = travelInfo;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
