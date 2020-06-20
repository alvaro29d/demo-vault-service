package com.ado.base.demo.vault.service;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;

public class PropertyContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                "eureka.host:hostOverridden",
                "eureka.port:portOverridden",
                "props.name:nameOverridden")
                .applyTo(configurableApplicationContext);
    }
}
