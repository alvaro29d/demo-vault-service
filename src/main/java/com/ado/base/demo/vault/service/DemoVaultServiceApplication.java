package com.ado.base.demo.vault.service;

import com.ado.base.demo.vault.service.api.EurekaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EurekaProperties.class)
public class DemoVaultServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoVaultServiceApplication.class, args);
    }

}
