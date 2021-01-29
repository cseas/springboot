package com.absingh.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.NumberFormat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private ApplicationContext ctx;

	@Autowired
	private NumberFormat nf;

	@Test
	public void defaultCurrency() {
		double amount = 12345678.901234;
		System.out.println(nf.format(amount));
	}

	@Test
	void contextLoads() {
		int count = ctx.getBeanDefinitionCount();
		System.out.println("There are " + count + " beans in the application context");

		for(String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
