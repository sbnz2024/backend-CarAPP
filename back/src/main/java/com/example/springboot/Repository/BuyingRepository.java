package com.example.springboot.Repository;

import com.example.springboot.model.Car;
import com.example.springboot.model.CarBuyingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyingRepository extends JpaRepository<CarBuyingRequest, Integer> {
}
