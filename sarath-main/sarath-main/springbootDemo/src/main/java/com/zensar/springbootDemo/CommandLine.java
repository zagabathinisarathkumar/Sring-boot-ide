package com.zensar.springbootDemo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CommandLine implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLine" + Arrays.deepToString(args));

	}

}
