package com.flight_reservation.dto;

import lombok.Data;

@Data
public class PdfRequest {

    private String filePath;
    private String name;
    private String emailId;
    private String phone;
    private String operatingAirline;
    private String departureDate;
    private String departureCity;
    private String arrivalCity;

    // Getters and setters
}
