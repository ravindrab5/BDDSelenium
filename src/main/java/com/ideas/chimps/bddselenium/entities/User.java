package com.ideas.chimps.bddselenium.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
enum UserTye{
    MARS_ADMIN,PROPERTY_USER,PROPERTY_ADMIN,ABOVE_PROPERTY;
}
*/

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
    private String role;
}
