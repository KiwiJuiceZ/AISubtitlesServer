package com.AISubtitles.Server.domain;

import org.springframework.stereotype.Component;
<<<<<<< HEAD

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "user_info")
=======
import java.sql.Date;


@Component
>>>>>>> ee2c2b0cef44ee90ff420df110f29c39318c8171
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
<<<<<<< HEAD
    @Column(name = "user_gender")
    private String UserGender;
    @Column(name = "user_birthday")
    private Date userBirthday;
    @Column(name = "user_passwrod")
    private String userPassword;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "image")
    private String image;
    @Column(name = "user_phone_number")
    private String userPhoneNumber;


=======
    private String userGender;
    private Date userBirthday;
    private String userPassword;
    private String userEmail;
    private String image;
    private String userPhoneNumber;


>>>>>>> ee2c2b0cef44ee90ff420df110f29c39318c8171
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", UserGender='" + userGender + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", image='" + image + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return UserGender;
    }

    public void setUserGender(String userGender) {
        UserGender = userGender;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}
