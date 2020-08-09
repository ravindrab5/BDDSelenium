package com.ideas.chimps.bddselenium.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Environment {

    @Value("${url}")
    private String url;

    @Value("${mars_user_pass}")
    private String marsUserPass;

    @Value("${mars_user}")
    private String marsUser;

}

