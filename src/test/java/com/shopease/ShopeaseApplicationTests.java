package com.shopease;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=test")
class ShopeaseApplicationTests {

	// Empty context load test
	@Test
	void contextLoads() {
	}

}
