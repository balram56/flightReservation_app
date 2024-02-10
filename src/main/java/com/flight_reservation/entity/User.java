package com.flight_reservation.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
public class User extends AbstractEntity {

    @Size(min = 2, message ="minimum 2 Character are required")
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Email
    @Column(unique = true, nullable = true)
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]{8,16}$",
            message = "Password must be 8-16 characters long and contain only letters and digits.")
    @Column(nullable = false)
    private String password;
}
