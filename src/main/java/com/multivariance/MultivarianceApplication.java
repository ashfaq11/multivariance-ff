package com.multivariance;

import io.harness.cf.client.api.BaseConfig;
import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.api.Event;
import io.harness.cf.client.api.FeatureFlagInitializeException;
import io.harness.cf.client.connector.HarnessConfig;
import io.harness.cf.client.connector.HarnessConnector;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MultivarianceApplication {
	String apiKey = "2351c0b5-f2e6-4b2d-be5c-c858f242b6a1";
	CfClient cfClient;
	private final Logger logger = LoggerFactory.getLogger(MultivarianceApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MultivarianceApplication.class, args);
	}


	@Bean
	public CfClient cfClient() throws FeatureFlagInitializeException, InterruptedException {
		HarnessConfig connectorConfig = HarnessConfig.builder().configUrl("https://config.ff.harness.io/api/1.0")
				.eventUrl("https://events.ff.harness.io/api/1.0").build();

		BaseConfig options = BaseConfig.builder().pollIntervalInSeconds(60).streamEnabled(true).analyticsEnabled(true)
				.build();

		cfClient = new CfClient(new HarnessConnector(apiKey, connectorConfig), options);

		cfClient.waitForInitialization();
		cfClient.on(Event.READY, result -> logger.info("Harness client initialized."));
		cfClient.on(Event.CHANGED, this::flagChangeEvent);
		return cfClient;
	}

	private void flagChangeEvent(String result){
		logger.info("Change event: " + result);
	}

	@Bean
	public WebMvcConfigurer corsConfiguration() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NotNull CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}