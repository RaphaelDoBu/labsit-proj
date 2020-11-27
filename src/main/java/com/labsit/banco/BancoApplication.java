package com.labsit.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"com.labsit.banco"})
@EnableJpaRepositories({"com.labsit.banco"})
@ComponentScan(basePackages = {"com.labsit.banco"})
@SpringBootApplication(scanBasePackages = "com.labsit.banco")
public class BancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

}
