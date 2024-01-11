package com.example.thuchanh2.service;

import com.example.thuchanh2.model.City;
import com.example.thuchanh2.respository.ICityRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class HibernateCityService implements ICityService {
    @Autowired
    ICityRespository iCityRespository;

    @Override
    public List<City> findAll() {
        return iCityRespository.findAll();
    }

    @Override
    public Optional<City> findById(int id) {
        return iCityRespository.findById(id);
    }

    @Override
    public void save(City city) {
        iCityRespository.save(city);
    }

    @Override
    public void delete(int id) {
        iCityRespository.deleteById(id);
    }

    @Override
    public void edit(int id, City city) {
        iCityRespository.save(new City(id, city.getName(), city.getCountry(), city.getAcreage(), city.getNumberOfPeople(), city.getGdp(), city.getDescription()));
    }
}
