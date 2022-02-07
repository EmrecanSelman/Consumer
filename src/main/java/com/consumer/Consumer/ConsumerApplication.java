package com.consumer.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		String port = System.getProperty("port", "8082");
		SpringApplication app = new SpringApplication(ConsumerApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", port));
		app.run(args);
	}

}
