package io.javabrains.covid19tracker;
/*
 * Author Name:Kshitij Sahu
 * IDE: intellij IDEA Community Edition
 * Date: 19-04-2022
 */

import io.javabrains.covid19tracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


@Service  // this is used to mark the method as a service

public class covid19VirusDataService {
     private  static  String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    // method to fetch data from the file

    private List<LocationStats> allStats = new ArrayList<>();

    @PostConstruct   // This is used to tell the spring that execute this method when the application start
    @Scheduled(cron = "* * * * * * ")
    // this annotation is used when tha application has to be run on daily bases and has to be updated
    // this '*' -> shows second,minute,hour,day,month,year

    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        // making the get method to get the data
        HttpClient client = HttpClient.newHttpClient();
        // making request from the sever
        // covid-19 data CSV file

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        // ofString -> take the body and just return as a string
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        // this code will  detect the header from the CSV file and remove it
        // StringReader is a instance of reader which parses string
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            String state = record.get("Province/State");
            System.out.println(state);

        }

    }
}
