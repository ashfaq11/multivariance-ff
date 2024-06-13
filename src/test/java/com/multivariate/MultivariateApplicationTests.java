package com.multivariate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.multivariate.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import io.harness.cf.client.api.FeatureFlagInitializeException;

@SpringBootTest
class MultiVariateApplicationTests {
	Logger logger = LoggerFactory.getLogger(MultiVariateApplicationTests.class);

	@Mock
	UserService userService;


	static String userEmail;

	@BeforeAll
	static void contextLoads() {
		userEmail = "user1@trinet.com";
	}

	@Test
	//@EnabledIfEnvironmentVariable(named = "multivariate-ff", matches = "1")
	void testMultiVariateFlag() throws InterruptedException {
 		when(userService.getFFStringValue(userEmail)).thenReturn("a");
		assertEquals(userService.getFFStringValue(userEmail), "a");
	}
}
