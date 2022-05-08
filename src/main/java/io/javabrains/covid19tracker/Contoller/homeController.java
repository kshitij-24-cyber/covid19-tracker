package io.javabrains.covid19tracker.Contoller;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 19-04-2022
 */

import io.javabrains.covid19tracker.covid19VirusDataService;
import io.javabrains.covid19tracker.models.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class homeController {
    @Autowired
    covid19VirusDataService covid19VirusDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allstats = covid19VirusDataService.getAllStats();
        int totalReportedCases =  allstats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
        int totalNewCases = allstats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();


        model.addAttribute("locationStats", allstats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);





        return "home";
    }
    }

