package com.ideas.chimps.bddselenium.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages = { "com.ideas.chimps.bddselenium.*" })
@PropertySources({
        @PropertySource("classpath:${env}.properties"),
        @PropertySource("classpath:common.properties"),
        @PropertySource("classpath:api.properties"),
        @PropertySource("classpath:jsons.properties")
})
public class EnvironmentConfig {


}
