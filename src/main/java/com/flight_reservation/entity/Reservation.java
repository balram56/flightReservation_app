package com.flight_reservation.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Reservation extends AbstractEntity{
    // "id" is come from AbstractEntity
    private boolean checkedIn;  //checked on gate true/false
    private int numberOfBags;
    @OneToOne
    private Passenger passenger; //Onetoone mapping
    @OneToOne
    private Flight flight;
    //getter and setter
}
