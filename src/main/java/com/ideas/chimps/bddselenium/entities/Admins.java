package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Admins {
    private String userAccountId;

    private String initials;

    private String firstName;

    private String lastName;

    private String email;

    private int contactOrder;


    public Admins(String initials, String firstName, String lastName, String email, int contactOrder) {
        this.initials = initials;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactOrder = contactOrder;
    }
}
