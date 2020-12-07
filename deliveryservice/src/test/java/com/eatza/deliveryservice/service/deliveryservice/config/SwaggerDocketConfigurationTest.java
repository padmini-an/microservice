package com.eatza.deliveryservice.service.deliveryservice.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.eatza.deliveryservice.config.SwaggerConfiguration;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

@SpringBootTest
@ContextConfiguration(classes = SwaggerConfiguration.class)
public class SwaggerDocketConfigurationTest {

	@Autowired
	Docket docket;

	@Autowired
	UiConfiguration uiconfiguration;

	@Test
	public void docketTest() {
		assertNotNull(docket);
	}

	@Test
	public void uiconfigurationTest() {
		assertNotNull(uiconfiguration);
	}

}
