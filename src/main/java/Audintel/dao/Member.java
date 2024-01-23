package Audintel.dao;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Member {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column
    private int memberCode;

    @Column(length = 30)
    private String firstName;
    @Column(length = 30)
    private String lastName;

    @Column
    private java.sql.Date dob;

    @Column(length = 40)
    private String email;

    @Column(length = 40)
    private String phno;

    @Column(length = 15)
    private String pswd;

    @Column
    private int points;

    @Column(length = 10)
    private String hno;

    @Column(length = 40)
    private String street;

    @Column(length = 30)
    private String village;

    @Column(length = 30)
    private String city;

    @Column(length = 30)
    private String state;

    @Column
    private int pincode;

    @Column(length = 30)
    private String createdAt;

    @Column(length = 30)
    private String createdBy;

    @Column(length = 30)
    private String updatedAt;

    @Column(length = 30)
    private String updatedBy;

    @Column(length = 30)
    private String isActive;


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getHno() {
        return hno;
    }

    public void setHno(String hno) {
        this.hno = hno;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
