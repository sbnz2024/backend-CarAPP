package com.example.springboot.Service;


import com.example.springboot.DTO.RentDTO;
import com.example.springboot.Repository.CarRepository;
import com.example.springboot.Repository.RentRepository;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.model.Car;
import com.example.springboot.model.Rent;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {



    @Autowired
    RentRepository rentRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserRepository userRepository;

    public RentDTO addRent(RentDTO rentDTO) {
        Car car = carRepository.findById(rentDTO.getCar().getId()).orElseThrow(() -> new RuntimeException("Car not found"));
        User user = userRepository.findById(rentDTO.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));

        Rent rent = new Rent();
        rent.setCar(car);
        rent.setUser(user);
        rent.setStartDate(rentDTO.getStartDate());
        rent.setEndDate(rentDTO.getEndDate());
        rent.setTotalPrice(rentDTO.getTotalPrice());

        // Save the rent entity
        Rent savedRent = rentRepository.save(rent);

        // Convert the saved entity back to DTO
        return new RentDTO(savedRent);
    }
}
