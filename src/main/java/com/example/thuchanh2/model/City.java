package com.example.thuchanh2.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Ban phai nhap ten")
    private String name;
    private String country;
    private int acreage;
    private int numberOfPeople;
    @Min(value = 10, message = "Ban phai nhap lon hon 10")
    private int gdp;
    private String description;

    public City(int id, String name, String country, int acreage, int numberOfPeople, int gdp, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.acreage = acreage;
        this.numberOfPeople = numberOfPeople;
        this.gdp = gdp;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City() {
    }

    public City(String name, String country, int acreage, int numberOfPeople, int gdp, String description) {
        this.name = name;
        this.country = country;
        this.acreage = acreage;
        this.numberOfPeople = numberOfPeople;
        this.gdp = gdp;
        this.description = description;
    }
}