package com.home.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.home.cardatabase.domain.Car;
import com.home.cardatabase.domain.CarRepository;

@SpringBootApplication
public class CardatabaseApplication {

	@Autowired
	private CarRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	public static void main(String[] args) {
		// After adding this comment the application is restarted
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}

	@Bean
	CommandLineRunner runner() {
		Car car1 = new Car();
		car1.setBrand("Porsche");
		// Car car2 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000);

		logger.info(car1.getBrand());

		return args -> {
			// save demo data to database
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000));
		};
	}
}
