package com.redis.redistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.redis.redistest")
public class RedistestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedistestApplication.class, args);
	}

}
