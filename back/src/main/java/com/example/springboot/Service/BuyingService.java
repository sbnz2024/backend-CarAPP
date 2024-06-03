package com.example.springboot.Service;


import com.example.springboot.DTO.CarBuyingRequestDTO;
import com.example.springboot.DTO.RentDTO;
import com.example.springboot.Repository.BuyingRepository;
import com.example.springboot.Repository.CarRepository;
import com.example.springboot.Repository.TransactionRepository;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.Util.DebugAgendaEventListener;
import com.example.springboot.model.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
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

    @Autowired
    TransactionRepository   transactionRepository;

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

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("ksession-rules");

        kSession.addEventListener(new DebugAgendaEventListener());

        for(CarBuyingRequest r: requests) {
            if(r.getRequestStatus() == CarBuyingRequest.RequestStatus.PENDING) {
                kSession.insert(r);

                requestsAcceptedNull.add(r);
            }
        }
      kSession.fireAllRules();

        for(CarBuyingRequest r: requestsAcceptedNull) {
            buyingRepository.save(r);
        }


        kSession.dispose(); // Ovo oslobađa resurse

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
        carBuyingRequest.setRequestStatus(buyDTO.getRequestStatus());

        LocalDate currentDate = LocalDate.now();

        // Dodaj 5 godina trenutnom datumu
        LocalDate maxDateLocal = currentDate.plusMonths(buyDTO.getNumberOfRate());


        LocalDate minDateLocal = currentDate.plusMonths(buyDTO.getNumberOfRate() - 10);

        // Konvertujemo LocalDate u Date za maxDateLocal
        Date maxDate = Date.from(maxDateLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Konvertujemo LocalDate u Date za minDateLocal
        Date minDate = Date.from(minDateLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        carBuyingRequest.setMaxTimeToPay(maxDate);
        carBuyingRequest.setMinTimeToPay(minDate);
        carBuyingRequest.setAiDecision(2);


        if (buyDTO.getEmployeedFrom() != null) {
            carBuyingRequest.setEmployeedFrom(buyDTO.getEmployeedFrom());
        }

        if (buyDTO.getWorkingTo() != null) {
            carBuyingRequest.setWorkingTo(buyDTO.getWorkingTo());
        }

        List<Transaction> transactions = transactionRepository.findTransactionByUser(carBuyingRequest.getUser());


        LocalDate minus1Month = currentDate.plusMonths(-1);
        LocalDate minus2Month = currentDate.plusMonths(-2);
        LocalDate minus3Month = currentDate.plusMonths(-3);
        LocalDate minus4Month = currentDate.plusMonths(-4);
        LocalDate minus5Month = currentDate.plusMonths(-5);
        LocalDate minus6Month = currentDate.plusMonths(-6);
        // Convert LocalDate to java.util.Date
        Date dateminus1Month = Date.from(minus1Month.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateminus2Month = Date.from(minus2Month.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateminus3Month = Date.from(minus3Month.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateminus4Month = Date.from(minus4Month.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateminus5Month = Date.from(minus5Month.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateminus6Month = Date.from(minus6Month.atStartOfDay(ZoneId.systemDefault()).toInstant());

        double mon1 = 0., mon2 = 0., mon3 = 0., mon4 = 0., mon5 = 0., mon6 = 0.;
        Integer i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0;

        for (Transaction t : transactions) {

            if (isSameMonth(t.getDate(), dateminus1Month)) {
                mon1 += t.getValue();
                i1++;
            } else if (isSameMonth(t.getDate(), dateminus2Month)) {
                mon2 += t.getValue();
                i2++;

            } else if (isSameMonth(t.getDate(), dateminus3Month)) {
                mon3 += t.getValue();
                i3++;
            } else if (isSameMonth(t.getDate(), dateminus4Month)) {
                mon4 += t.getValue();
                i4++;
            } else if (isSameMonth(t.getDate(), dateminus5Month)) {
                mon5 += t.getValue();
                i5++;
            } else if (isSameMonth(t.getDate(), dateminus6Month)) {
                mon6 += t.getValue();
                i6++;
            }

        }

        double income1 = 0;
        double income2 =0;
        double income3 = 0;
        double income4 =0;
        double income5 = 0;
        double income6 = 0;
        if (i1 != 0 && i2 != 0 && i3 != 0 && i4 != 0 && i5 != 0 && i6 != 0) {
            income1 = mon1 / i1;
            income2 = mon2 / i2;
            income3 = mon3 / i3;
           income4 = mon4 / i4;
           income5 = mon5 / i5;
           income6 = mon6 / i6;
        }

        if (income1 > carBuyingRequest.getNumberOfRate() && income2 > carBuyingRequest.getNumberOfRate() && income3 > carBuyingRequest.getNumberOfRate() && income4 > carBuyingRequest.getNumberOfRate() && income5 > carBuyingRequest.getNumberOfRate() && income6 > carBuyingRequest.getNumberOfRate())
        {
            carBuyingRequest.setStableIncome(true);
        }
        else
        {
            carBuyingRequest.setStableIncome(false);
        }

            // Save the rent entity
            CarBuyingRequest savedBuy = buyingRepository.save(carBuyingRequest);

        // Convert the saved entity back to DTO
        return new CarBuyingRequestDTO(savedBuy);
    }


    private static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(date1);
        cal2.setTime(date2);

        int month1 = cal1.get(Calendar.MONTH);
        int year1 = cal1.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);
        int year2 = cal2.get(Calendar.YEAR);

        return month1 == month2 && year1 == year2;
    }
}

