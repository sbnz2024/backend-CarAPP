package com.example.springboot.Controller;


import com.example.springboot.DTO.RentDTO;
import com.example.springboot.Service.CarService;
import com.example.springboot.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/rents")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping("/add")
    public ResponseEntity<RentDTO> addRent(@RequestBody RentDTO rentDTO) {
        RentDTO savedRentDTO = rentService.addRent(rentDTO);
        if (savedRentDTO != null) {
            return new ResponseEntity<>(savedRentDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
