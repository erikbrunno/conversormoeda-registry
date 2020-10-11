package com.bcb.conversaomoeda;

import java.util.TimeZone;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ConversorMoedaRegistryApiApplication {

	private static final String UTC = "UTC";

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone(UTC));
		SpringApplication.run(ConversorMoedaRegistryApiApplication.class, args);
	}

}
