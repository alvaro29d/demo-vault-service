package com.ado.base.demo.vault.service.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PropertiesRunner implements CommandLineRunner {

    private final EurekaProperties eurekaProperties;

    @Value("${props.name}")
    private String value;

    @Override
    public void run(String... args) {
        log.info("profile='{}'", System.getenv("PROFILE"));
        log.info("eureka host='{}', port='{}'", eurekaProperties.getHost(), eurekaProperties.getPort());
        log.info("props.name='{}'", value);
    }
}
