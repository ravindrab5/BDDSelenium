package com.ideas.chimps.bddselenium.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CommonConfig {

    @Value("${browser}")
    private String browser;

    @Value("${hub_url}")
    private String hubUrl;

    @Value("${base_api}")
    private String baseApiUrl;

}
