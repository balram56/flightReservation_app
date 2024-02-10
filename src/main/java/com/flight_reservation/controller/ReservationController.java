package com.flight_reservation.controller;

import com.flight_reservation.dto.ReservationRequest;
import com.flight_reservation.entity.Reservation;
import com.flight_reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    //@RequestParam is used when not be  entity laye, when not to wnt used @RequestParam for maximum nuber of attribute then be used to DTO laye
    //@ModelAttribute is used when entity layer is prsent
    //Confirm reservations

    @RequestMapping("/confirmReservation")
    public String confirmReservation(
            ReservationRequest reservationRequest,
             ModelMap modelMap
    ){
        Reservation reservationId = reservationService.bookFlight(reservationRequest);
        modelMap.addAttribute("reservationId", reservationId.getId());
        return "confirmReservation";
    }
}
