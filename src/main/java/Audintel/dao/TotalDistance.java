package Audintel.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "total_distance")
public class TotalDistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "total_distance")
    private long totalDistance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    private int code;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member member;


}
