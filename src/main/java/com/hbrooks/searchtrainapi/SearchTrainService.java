package com.hbrooks.searchtrainapi;

import com.hbrooks.searchtrainapi.apiresponsemodel.TrainSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

//wrapper for the realtraintime api
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

    //all requests send stations in CRS format e.g. BMO - birmingham moor street
    public TrainSearchResponse findTrainJourney(String originStationCRS, String destinationStationCRS){

        //create request - including basic http auth in headers
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/json/search/{origin}/to/{destination}")
                        .build(originStationCRS,destinationStationCRS))
                .headers(httpHeaders -> httpHeaders.setBasicAuth(username,password))
                .retrieve()
                //map to response class
                .bodyToMono(TrainSearchResponse.class)
                .block();
    }

    //retrieve the service uid and the correctly formatted date of the next journey
    public String[] getIdAndDate(String originCRS, String destinationCRS){

        String[] result = new String[2];

        TrainSearchResponse trainSearchResponse = findTrainJourney(originCRS,destinationCRS);

        result[0] = trainSearchResponse.getServices().get(0).getServiceUid();

        //api gives date in yyyy-mm-dd format - required in yyyy/mm/dd format
        String date = trainSearchResponse.getServices().get(0).getRunDate();
        String[] splitDate = date.split("-");
        result[1] = String.join("/", splitDate);

        return result;
    }
}
