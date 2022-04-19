package io.javabrains.covid19tracker;
/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 19-04-2022
 */

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service  // this is used to mark the method as a service

public class covid19VirusDataService {
    // covid-19 data CSV file
    private  final  String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    // method to fetch data from the file


    @PostConstruct   // This is used to tell the spring that execute this method when the application start

    public void fetchVirusData() throws IOException, InterruptedException {
    // making the get method to get the data
        HttpClient client = HttpClient.newHttpClient();
        // making request from the sever
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        // ofString -> take the body and just return as a string
       HttpResponse<String> httpResponse  =client.send(request, HttpResponse.BodyHandlers.ofString());
       // printing the data
        System.out.println(httpResponse.body());

    }
}
