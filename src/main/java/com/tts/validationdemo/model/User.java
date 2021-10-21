package com.tts.validationdemo.model;


import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty //whatever this is annotating is not going to be ignored
    @NotNull(message = "Name cannot be null")
    @Pattern(regexp = "[^\\s]+", message="Your username cannot contain spaces")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    // @AssertFalse
//    @AssertTrue
//    private boolean isWorking;
//
//    @Min(value = 18, message = "You need to be at least 18 years old")
//    private int age;
//
//    @CreditCardNumber(message = "Please input a valid credit card number")
//    private long creditCardNumber;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String username, String email) {

        this.username = username;
        this.email = email;
    }
//    public boolean isWorking() {
//        return isWorking;
//    }

//    public void setWorking(boolean working) {
//        isWorking = working;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

//    public long getCreditCardNumber() {
//        return creditCardNumber;
//    }
//
//    public void setCreditCardNumber(long creditCardNumber) {
//        this.creditCardNumber = creditCardNumber;
//    }

    /*
    //@Past
    //@PastOrPresent
    //@Future
     */

}
