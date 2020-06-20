package com.ado.base.demo.vault.service;

import com.ado.base.demo.vault.service.api.EurekaProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@ContextConfiguration(initializers = PropertyFileContextInitializer.class)
class PropertyFileOverrideTests {

	@Autowired
	private EurekaProperties eurekaProperties;

	@Value("${props.name}")
	private String name;

	@Test
	void contextLoads() {
		assertThat(eurekaProperties.getHost(), is("hostOverriddenFromPropertyFile"));
		assertThat(eurekaProperties.getPort(), is("portOverriddenFromPropertyFile"));
		assertThat(name, is("nameOverriddenFromPropertyFile"));
	}

}
