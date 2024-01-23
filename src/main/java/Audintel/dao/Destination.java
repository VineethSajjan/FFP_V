package Audintel.dao;


import jakarta.persistence.*;

@Entity
public class Destination {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)

    int dest_Id;
    @Column
    String origin;
    @Column
    String destination;
    @Column
    int kms;

    public int getDest_Id() {
        return dest_Id;
    }

    public void setDest_Id(int dest_Id) {
        this.dest_Id = dest_Id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }
}
