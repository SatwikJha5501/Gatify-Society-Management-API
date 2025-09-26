package com.Gatify.gatifyBackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaint")
public class Complaint {

    public enum ComplaintType {
        Electrician, Plumber, Launderer, Carpenter, PestControl
    }

    public enum ComplaintStatus {
        Pending, Assigned, Resolved
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "society_id")
    private int societyId;

    @Column(name = "block_id")
    private int blockId;

    @Column(name = "flat_id")
    private int flatId;

    @Enumerated(EnumType.STRING)
    @Column(name = "complaint_type")
    private ComplaintType complaintType;

    @Enumerated(EnumType.STRING)
    @Column(name = "complaint_status")
    private ComplaintStatus complaintStatus = ComplaintStatus.Pending;

    @Column(name = "person_assigned_name")
    private String personAssignedName;

    @Column(name = "person_assigned_number")
    private String personAssignedNumber;

    public Complaint() {}

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getSocietyId() { return societyId; }
    public void setSocietyId(int societyId) { this.societyId = societyId; }
    public int getBlockId() { return blockId; }
    public void setBlockId(int blockId) { this.blockId = blockId; }
    public int getFlatId() { return flatId; }
    public void setFlatId(int flatId) { this.flatId = flatId; }
    public ComplaintType getComplaintType() { return complaintType; }
    public void setComplaintType(ComplaintType complaintType) { this.complaintType = complaintType; }
    public ComplaintStatus getComplaintStatus() { return complaintStatus; }
    public void setComplaintStatus(ComplaintStatus complaintStatus) { this.complaintStatus = complaintStatus; }
    public String getPersonAssignedName() { return personAssignedName; }
    public void setPersonAssignedName(String personAssignedName) { this.personAssignedName = personAssignedName; }
    public String getPersonAssignedNumber() { return personAssignedNumber; }

    public void setPersonAssignedNumber(String personAssignedNumber) {
        if(personAssignedNumber != null && personAssignedNumber.matches("\\d{10}")) {
            this.personAssignedNumber = personAssignedNumber;
        } else {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
    }
}