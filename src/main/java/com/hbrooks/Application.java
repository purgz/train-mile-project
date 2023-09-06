package com.hbrooks;

import com.hbrooks.entity.TrainStationLocation;
import com.hbrooks.service.TrainStationLocationService;
import com.hbrooks.service.trainmileage.MileageService;
import com.hbrooks.service.trainmileage.MileageTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private TrainStationLocationService trainStationLocationService;

	@Autowired
	private MileageService mileageService;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

			//TrainStationLocation trainStationLocation = trainStationLocationService.findByCrs("BCS");

			//System.out.println(trainStationLocation);

			//MileageTable table = mileageService.mileageTable(113);

			//System.out.println(table);


			//System.out.println(mileageService.getStationsTables("BCS"));

			System.out.println(mileageService.getDistanceBetweenTwoStations("BIT","WCX") + " miles");


		};
	}


}
