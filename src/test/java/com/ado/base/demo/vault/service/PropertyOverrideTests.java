package com.ado.base.demo.vault.service;

import com.ado.base.demo.vault.service.api.EurekaProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@ContextConfiguration(initializers = PropertyContextInitializer.class)
class PropertyOverrideTests {

	@Autowired
	private EurekaProperties eurekaProperties;

	@Value("${props.name}")
	private String name;

	@Test
	void contextLoads() {
		assertThat(eurekaProperties.getHost(), is("hostOverridden"));
		assertThat(eurekaProperties.getPort(), is("portOverridden"));
		assertThat(name, is("nameOverridden"));
	}

}
