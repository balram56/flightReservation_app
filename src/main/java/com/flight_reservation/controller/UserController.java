package com.flight_reservation.controller;

import com.flight_reservation.entity.User;
import com.flight_reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepo;

    //Direct go to login page and register page for url below
   // http://localhost:8080/flights
    //Direct go to login page
   // http://localhost:8080/flights/showLoginPage
    @RequestMapping("/showLoginPage")
    public String showLoginPage(){
        return "login";
    }

    //Show Reg page
     //  http://localhost:8080/flights/showReg

    @RequestMapping("/showReg")
    public String showReg(){
        return "showReg";
    }
    //Crate and save registration

    //validation
    @RequestMapping(value = "/showReg", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "showReg"; // return the name of your registration form page
    }
    @RequestMapping("/saveReg")
    public String saveReg(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult,
                          Model model
    ){
        if (bindingResult.hasErrors()) {
            return "showReg"; // return to the registration form page to display errors
        }
        try {
            userRepo.save(user);
        } catch (DataIntegrityViolationException e) {
            // This exception occurs when trying to insert a duplicate email
            model.addAttribute("errorMessage", "Email address already exists. Please choose a different email.");
            return "showReg";
        }
        return "login";
    }

    //for verify login
    @RequestMapping("/verifyLogin")
    public String verifyLogin(

            @RequestParam("emailId") String emailId,
            @RequestParam("password") String password,
            Model model

    ) {
        User user = userRepo.findByEmail(emailId);

        if (user != null) {
            if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
                return "findFlights";
            } else {
                model.addAttribute("error", "invalid username / password");
                return "login";
            }

        } else {
            model.addAttribute("error", "invalid username / password");
            return "login";
        }
    }
}
