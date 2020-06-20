package com.ado.base.demo.vault.service;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.vault.VaultContainer;

@SpringBootTest
@Ignore
@ContextConfiguration(initializers = EurekaIntegrationTest.ProperiesInitializer.class)
public class EurekaIntegrationTest {

    @Rule
    GenericContainer simpleContainer = new GenericContainer("3.11.5")
            .withExposedPorts(80);

    private static final VaultContainer VAULT_CONTAINER;

    static {

        VAULT_CONTAINER = new VaultContainer()
                .withVaultToken("12345")
                .withSecretInVault("services/demo-vault", "props.name=nameFromVault")
                .withSecretInVault("shared/endpoints", "eureka.host=eurekaHost", "eureka.port=8761")
                .withSecretInVault("services/demo-vault/prod", "props.name=prodnameFromVault")
                .withSecretInVault("shared/endpoints/prod", "eureka.host=prodEurekaHost", "eureka.port=8761");

        VAULT_CONTAINER.start();

        System.getProperties().put("spring.cloud.vault.port", VAULT_CONTAINER.getFirstMappedPort());
        System.getProperties().put("props.name", "propsFromSystemProperty");

    }

    static class ProperiesInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues
                    .of("spring.cloud.vault.port=" + VAULT_CONTAINER.getFirstMappedPort())
                    .applyTo(configurableApplicationContext);
        }
    }

    @Test
    public void loadConfig() {
        Integer firstMappedPort = simpleContainer.getFirstMappedPort();
        System.out.println(firstMappedPort);
    }

}
