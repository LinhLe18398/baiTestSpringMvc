package com.example.thuchanh2.service;

import com.example.thuchanh2.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> findAll();
    Optional<City> findById(int id);
    void save(City city);
    void delete(int id);
    void edit(int id, City city);
}
