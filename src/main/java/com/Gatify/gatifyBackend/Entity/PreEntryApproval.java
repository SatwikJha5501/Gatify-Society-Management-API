package com.Gatify.gatifyBackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pre_entry_approval")
public class PreEntryApproval {

    public enum Type {
        Guest, Cab, Delivery, VisitingHelp
    }

    public enum Status {
        SurpriseDelivery, UsualDelivery
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String date; // Format: "dd:MM:yyyy"
    private String startingTime; // Format: "hh:mm a"
    private int hours;
    private String companyName;

    // Constructors
    public PreEntryApproval() {}

    public PreEntryApproval(Type type, Status status, String date,
                            String startingTime, int hours, String companyName) {
        this.type = type;
        this.status = status;
        this.date = date;
        this.startingTime = startingTime;
        this.hours = hours;
        this.companyName = companyName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // toString
    @Override
    public String toString() {
        return "PreEntryApproval{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", date='" + date + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", hours=" + hours +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}