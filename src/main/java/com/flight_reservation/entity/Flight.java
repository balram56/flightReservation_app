package com.flight_reservation.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class Flight extends AbstractEntity{

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;

}
