package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {
	SpringSecurityApplication ssa;
	
	@Test
	void contextLoads() {
		String[] args = {"asdf", "qwer"};
		
		ssa.main(args);
	}
}
