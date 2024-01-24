package Audintel.dao;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordert")
public class Order {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name="store_id")
    private int storeId;

    @Column(name = "member_id")
    private int memberId;

    @Column(name = "cost")
    private int cost;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "status")
    private Boolean status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getMember() {
        return memberId;
    }

    public void setMember(int member_Id) {
        this.memberId=member_Id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

