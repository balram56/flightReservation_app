package com.flight_reservation.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Passenger extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
}
