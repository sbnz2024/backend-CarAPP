package com.example.springboot.Service;


import com.example.springboot.DTO.CarBuyingRequestDTO;
import com.example.springboot.DTO.RentDTO;
import com.example.springboot.Repository.BuyingRepository;
import com.example.springboot.Repository.CarRepository;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.model.Car;
import com.example.springboot.model.CarBuyingRequest;
import com.example.springboot.model.Rent;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BuyingService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuyingRepository buyingRepository;

    public CarBuyingRequestDTO updateCarBuyingRequest(CarBuyingRequestDTO requestDTO) {
        CarBuyingRequest existingRequest = buyingRepository.findById(requestDTO.getId())
                .orElseThrow(() -> new RuntimeException("CarBuyingRequest not found"));

      Car car = carRepository.findById(requestDTO.getCar().getId()).orElseThrow(() -> new RuntimeException("Car not found"));
       /*  User user = userRepository.findById(requestDTO.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));

        existingRequest.setCar(car);
        existingRequest.setUser(user);
        existingRequest.setLoanAmount(requestDTO.getLoanAmount());
        existingRequest.setStatus(requestDTO.getStatus());
        existingRequest.setNumberOfRate(requestDTO.getNumberOfRate());
        existingRequest.setMonthlyIncome(requestDTO.getMonthlyIncome());

        if (requestDTO.getEmployeedFrom() != null) {
            existingRequest.setEmployeedFrom(requestDTO.getEmployeedFrom());
        }

        if (requestDTO.getWorkingTo() != null) {
            existingRequest.setWorkingTo(requestDTO.getWorkingTo());
        }
        */

        existingRequest.setRequestStatus(requestDTO.getRequestStatus());
        car.setCarBuyingRequest(existingRequest);

        if(requestDTO.getRequestStatus()== CarBuyingRequest.RequestStatus.REJECTED)
        {
            car.setCarBuyingRequest(null);
        }

        carRepository.save(car);
        CarBuyingRequest updatedRequest = buyingRepository.save(existingRequest);

        return new CarBuyingRequestDTO(updatedRequest);
    }



    public List<CarBuyingRequest> getAllForReview(){

        List<CarBuyingRequest> requests = buyingRepository.findAll();
        List<CarBuyingRequest> requestsAcceptedNull = new ArrayList<>();
            for( CarBuyingRequest r: requests)
            {
                if(r.getRequestStatus()== CarBuyingRequest.RequestStatus.PENDING)
                {
                    requestsAcceptedNull.add(r);
                }
            }
        return requestsAcceptedNull;
    }




    public CarBuyingRequestDTO buy(CarBuyingRequestDTO buyDTO) {
        Car car = carRepository.findById(buyDTO.getCar().getId()).orElseThrow(() -> new RuntimeException("Car not found"));
        User user = userRepository.findById(buyDTO.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));

        CarBuyingRequest carBuyingRequest = new CarBuyingRequest();
        carBuyingRequest.setCar(car);
        carBuyingRequest.setUser(user);
        carBuyingRequest.setLoanAmount(buyDTO.getLoanAmount());
        carBuyingRequest.setStatus(buyDTO.getStatus());
        carBuyingRequest.setNumberOfRate(buyDTO.getNumberOfRate());
        carBuyingRequest.setMonthlyIncome(buyDTO.getMonthlyIncome());
        carBuyingRequest.setAge(buyDTO.getAge());


        LocalDate currentDate = LocalDate.now();

        // Dodaj 5 godina trenutnom datumu
        LocalDate maxDateLocal = currentDate.plusMonths(buyDTO.getNumberOfRate());


        LocalDate minDateLocal = currentDate.plusMonths(buyDTO.getNumberOfRate()-10);

        // Konvertujemo LocalDate u Date za maxDateLocal
        Date maxDate = Date.from(maxDateLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Konvertujemo LocalDate u Date za minDateLocal
        Date minDate = Date.from(minDateLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        carBuyingRequest.setMaxTimeToPay(maxDate);
        carBuyingRequest.setMinTimeToPay(minDate);
        carBuyingRequest.setAiDecision(CarBuyingRequest.Decision.Waiting);


        if(buyDTO.getEmployeedFrom()!=null)
        {
            buyDTO.setEmployeedFrom(buyDTO.getEmployeedFrom());
        }

        if(buyDTO.getWorkingTo()!=null)
        {
            buyDTO.setWorkingTo(buyDTO.getWorkingTo());
        }


        // Save the rent entity
        CarBuyingRequest savedBuy =buyingRepository.save(carBuyingRequest);

        // Convert the saved entity back to DTO
        return new CarBuyingRequestDTO(savedBuy);
    }

}

