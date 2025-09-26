package com.Gatify.gatifyBackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entry_approval")
public class EntryApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "flat_resident_id")
    private User flatResident;

    @Column(name = "enterer_name")
    private String entererName;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus status = ApprovalStatus.Pending;

    public enum ApprovalStatus {
        Pending, Approved, Declined
    }

    // Constructors
    public EntryApproval() {}

    public EntryApproval(String companyName, User flatResident, String entererName) {
        this.companyName = companyName;
        this.flatResident = flatResident;
        this.entererName = entererName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public User getFlatResident() {
        return flatResident;
    }

    public void setFlatResident(User flatResident) {
        this.flatResident = flatResident;
    }

    public String getEntererName() {
        return entererName;
    }

    public void setEntererName(String entererName) {
        this.entererName = entererName;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }

    // toString()
    @Override
    public String toString() {
        return "EntryApproval{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", flatResident=" + flatResident +
                ", entererName='" + entererName + '\'' +
                ", status=" + status +
                '}';
    }
}