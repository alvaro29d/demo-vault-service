package com.ado.base.demo.vault.service.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("eureka")
public class EurekaProperties {

    private String host;
    private String port;

}
