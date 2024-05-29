package com.example.springboot.Controller;

import com.example.springboot.DTO.CarDTO;
import com.example.springboot.Service.CarService;
import com.example.springboot.model.Car;
import com.example.springboot.model.CarBuyingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "/")
    ResponseEntity<List<CarDTO>> getAll(){
        List<Car> cars = carService.findAll();

        List<CarDTO> carsDTO = new ArrayList<>();
        for(Car c : cars){
            if(c.getCarBuyingRequest()!=null && c.getCarBuyingRequest().getRequestStatus() == CarBuyingRequest.RequestStatus.ACCEPTED)
            {
                continue;
            }


                carsDTO.add(new CarDTO(c));

        }
        return new ResponseEntity<>(carsDTO, HttpStatus.OK);
    }

}
