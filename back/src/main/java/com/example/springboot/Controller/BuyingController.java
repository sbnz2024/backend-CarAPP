package com.example.springboot.Controller;


import com.example.springboot.DTO.CarBuyingRequestDTO;
import com.example.springboot.DTO.CarDTO;
import com.example.springboot.DTO.RentDTO;
import com.example.springboot.Service.BuyingService;
import com.example.springboot.Service.RentService;
import com.example.springboot.model.Car;
import com.example.springboot.model.CarBuyingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/buying")
public class BuyingController {

    @Autowired
    BuyingService   buyingService;



    @PutMapping("/update")
    public ResponseEntity<CarBuyingRequestDTO> updateCarBuyingRequest(@RequestBody CarBuyingRequestDTO requestDTO) {
        CarBuyingRequestDTO updatedBuyDTO = buyingService.updateCarBuyingRequest(requestDTO);
        if (updatedBuyDTO != null) {
            return new ResponseEntity<>(updatedBuyDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PostMapping("/add")
    public ResponseEntity<CarBuyingRequestDTO> buy(@RequestBody CarBuyingRequestDTO requestDTO) {
        CarBuyingRequestDTO savedBuyDTO = buyingService.buy(requestDTO);
        if (savedBuyDTO != null) {
            return new ResponseEntity<>(savedBuyDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    ResponseEntity<List<CarBuyingRequestDTO >> getAllForReview(){
        List<CarBuyingRequest> carBuyingRequest = buyingService.getAllForReview();

        List<CarBuyingRequestDTO> carBuyingRequestDTO = new ArrayList<>();
        for(CarBuyingRequest r : carBuyingRequest){
            carBuyingRequestDTO.add(new CarBuyingRequestDTO(r));
        }
        return new ResponseEntity<>(carBuyingRequestDTO , HttpStatus.OK);
    }






}
