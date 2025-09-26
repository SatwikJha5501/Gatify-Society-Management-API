package com.Gatify.gatifyBackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_flat_relation")
public class UserFlatRelation {

    public enum Status {
        PENDING, ACTIVE, INACTIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "society_id", nullable = false)
    private Long societyId;

    @Column(name = "block_id", nullable = false)
    private Long blockId;

    @Column(name = "flat_id", nullable = false)
    private Long flatId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.PENDING;

    // Constructors
    public UserFlatRelation() {
    }

    public UserFlatRelation(Long userId, Long societyId, Long blockId, Long flatId) {
        this.userId = userId;
        this.societyId = societyId;
        this.blockId = blockId;
        this.flatId = flatId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSocietyId() {
        return societyId;
    }

    public void setSocietyId(Long societyId) {
        this.societyId = societyId;
    }

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getFlatId() {
        return flatId;
    }

    public void setFlatId(Long flatId) {
        this.flatId = flatId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}