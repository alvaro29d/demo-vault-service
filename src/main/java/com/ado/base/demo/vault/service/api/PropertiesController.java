package com.ado.base.demo.vault.service.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PropertiesController {

    private final EurekaProperties eurekaProperties;

    @Value("${props.name}")
    private String value;

    @RequestMapping("/props")
    public EurekaProperties getProperties() {
        return eurekaProperties;
    }

    @RequestMapping("/value")
    public String getValue() {
        return value;
    }

}
