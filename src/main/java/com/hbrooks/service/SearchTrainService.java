package com.hbrooks.service;

import com.hbrooks.model.TrainSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SearchTrainService {

    //values from the env.properties file
    @Value("${REAL_TIME_TRAIN_USERNAME}")
    private String username;
    @Value("${REAL_TIME_TRAIN_PASSWORD}")
    private String password;

    private final WebClient webClient;
    private final String url = "https://api.rtt.io/api/v1";

    @Autowired
    public SearchTrainService(WebClient.Builder builder){

        webClient = builder.baseUrl(url).build();
    }


    public TrainSearchResponse findTrainJourney(String originStationCRS, String destinationStationCRS){

        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/json/search/{origin}/to/{destination}")
                        .build(originStationCRS,destinationStationCRS))
                .headers(httpHeaders -> httpHeaders.setBasicAuth(username,password))
                .retrieve()
                .bodyToMono(TrainSearchResponse.class)
                .block();
    }
}
