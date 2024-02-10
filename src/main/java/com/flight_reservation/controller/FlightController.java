package com.flight_reservation.controller;

import com.flight_reservation.entity.Flight;
import com.flight_reservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepo;

    //for flights search
    @RequestMapping("/findFlights")
    public String findFlights(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
            ModelMap modelMap
    ) {
        List<Flight> findFlights = flightRepo.findFlights(from, to, departureDate);

        modelMap.addAttribute("findFlights", findFlights);
        return "displayFlights";
    }

    //show flight reservation
    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(
            @RequestParam("flightId") long flightId,
            ModelMap modelMap
    ){
        Optional<Flight> findById = flightRepo.findById(flightId);
        Flight flight = findById.get();
       //sharing data from frontend
        modelMap.addAttribute("flight", flight);
        return "showReservation";
    }

}
