package com.ozerin.entities;

import jakarta.persistence.*;

import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "passport_data", unique = true)
    private String passportData;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    public Client(){
    }
    public Client(String fullName, String passportData, String maritalStatus, String address, String phone) {
        this.fullName = fullName;
        this.passportData = passportData;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
