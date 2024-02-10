package com.flight_reservation.service.Impl;

import com.flight_reservation.dto.ReservationRequest;
import com.flight_reservation.entity.Flight;
import com.flight_reservation.entity.Passenger;
import com.flight_reservation.entity.Reservation;
import com.flight_reservation.repository.FlightRepository;
import com.flight_reservation.repository.PassengerRepository;
import com.flight_reservation.repository.ReservationRepository;
import com.flight_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepo;
    @Autowired
    private PassengerRepository passengerRepo;
    @Autowired
    private FlightRepository flightRepo;
    @Override
    public Reservation bookFlight(ReservationRequest request) {

         //three data configuration here , flight details, passenger detail, and store in reservation table
        //get passenger details

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getFirstName());
        passenger.setMiddleName(request.getMiddleName());
        passenger.setLastName(request.getLastName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());

        passengerRepo.save(passenger);

        long flightId = request.getFlightId();
        Optional<Flight> findById = flightRepo.findById(flightId);
        Flight flight = findById.get();

        //for reservation save in database

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);
        reservation.setNumberOfBags(0);

        reservationRepo.save(reservation);


        return reservation;
    }
}
