package com.Gatify.gatifyBackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "notice_message")
    private String noticeMessage;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_mobile_number")
    private String userMobileNumber;

    public Notice() {}

    public Notice(String noticeMessage, int userId, String userMobileNumber) {
        this.noticeMessage = noticeMessage;
        this.userId = userId;
        this.userMobileNumber = userMobileNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoticeMessage() {
        return noticeMessage;
    }

    public void setNoticeMessage(String noticeMessage) {
        this.noticeMessage = noticeMessage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", noticeMessage='" + noticeMessage + '\'' +
                ", userId=" + userId +
                ", userMobileNumber='" + userMobileNumber + '\'' +
                '}';
    }
}