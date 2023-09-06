package com.hbrooks;

import com.hbrooks.trainstation.TrainStationService;
import com.hbrooks.trainmileage.MileageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private MileageService mileageService;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

			//System.out.println(mileageService.getDistanceBetweenTwoStations("BIT","WCX") + " miles");

		};
	}


}
