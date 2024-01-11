package com.example.thuchanh2.respository;

import com.example.thuchanh2.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRespository extends JpaRepository<City, Integer> {
}
