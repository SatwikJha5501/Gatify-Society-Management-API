package com.Gatify.gatifyBackend.Entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "society")
public class Society {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonAlias({"societyId", "id"})
    private int id;

    @Column(name = "society_name")
    private String societyName;

    private String location;
    private String area;

    @Column(name = "number_of_blocks")
    private int numberOfBlocks;

    @Column(name = "pin_code")
    private String pinCode;

    public Society() {
    }

    public Society(String societyName, String location, String area, int numberOfBlocks, String pinCode) {
        this.societyName = societyName;
        this.location = location;
        this.area = area;
        this.numberOfBlocks = numberOfBlocks;
        this.pinCode = pinCode;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getNumberOfBlocks() {
        return numberOfBlocks;
    }

    public void setNumberOfBlocks(int numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}