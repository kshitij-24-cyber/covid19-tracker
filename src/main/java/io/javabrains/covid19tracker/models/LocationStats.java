package io.javabrains.covid19tracker.models;/*
 * Author Name:Kshitij sahu
 * IDE: intellij IDEA Community Edition
 * Date: 19-04-2022
 */

import org.springframework.web.bind.annotation.GetMapping;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;
    private int DiffFromPrevDay;

    public int getDiffFromPrevDay() {

        return DiffFromPrevDay;
    }

    public void setDiffFromPrevDay(int DiffFromPrevDay) {
        this.DiffFromPrevDay = DiffFromPrevDay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
