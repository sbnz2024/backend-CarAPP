package com.example.springboot.Service;

import com.example.springboot.Repository.CarRepository;
import com.example.springboot.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {

    @Autowired
    CarRepository carRepository;



    public List<Car> findAll(){
        return carRepository.findAll();
    }


}
