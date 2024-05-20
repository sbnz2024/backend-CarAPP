package com.example.springboot.DTO;



import com.example.springboot.model.Car;
import com.example.springboot.model.User;
import com.example.springboot.model.Rent;

import java.util.Date;

public class RentDTO {
    private Integer id;
    private CarDTO car;
    private UserDTO user;
    private Date startDate;
    private Date endDate;
    private Double totalPrice;

    // Default constructor
    public RentDTO() {
    }

    // Constructor to convert Rent entity to RentDTO
    public RentDTO(Rent rent) {
        this.id = rent.getId();
        this.car = new CarDTO(rent.getCar());
        this.user = new UserDTO(rent.getUser());
        this.startDate = rent.getStartDate();
        this.endDate = rent.getEndDate();
        this.totalPrice = rent.getTotalPrice();
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
