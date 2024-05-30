package com.example.springboot.DTO;

import com.example.springboot.model.CarBuyingRequest;
import jakarta.persistence.Column;

import java.util.Date;

public class CarBuyingRequestDTO {
    private Integer id;
    private Double monthlyIncome;
    private Double loanAmount;
    private Integer numberOfRate;
    private CarDTO car;
    private UserDTO user;
    private CarBuyingRequest.Status status;
    private Date employeedFrom;
    private Date workingTo;
    private CarBuyingRequest.RequestStatus requestStatus;
    private Integer age;


    private Date maxTimeToPay;


    private Date minTimeToPay;


   // private CarBuyingRequest.Decision aiDecision;

    // Default constructor
    public CarBuyingRequestDTO() {
    }

    // Constructor to convert CarBuyingRequest entity to CarBuyingRequestDTO
    public CarBuyingRequestDTO(CarBuyingRequest carBuyingRequest) {
        this.id = carBuyingRequest.getId();
        this.monthlyIncome = carBuyingRequest.getMonthlyIncome();
        this.loanAmount = carBuyingRequest.getLoanAmount();
        this.numberOfRate = carBuyingRequest.getNumberOfRate();
        this.car = new CarDTO(carBuyingRequest.getCar());
        this.user = new UserDTO(carBuyingRequest.getUser());
        this.status = carBuyingRequest.getStatus();
        this.employeedFrom = carBuyingRequest.getEmployeedFrom();
        this.workingTo = carBuyingRequest.getWorkingTo();
        this.requestStatus=carBuyingRequest.getRequestStatus();
        this.age=carBuyingRequest.getAge();
        this.maxTimeToPay=carBuyingRequest.getMaxTimeToPay();
        this.minTimeToPay=carBuyingRequest.getMinTimeToPay();
       // this.aiDecision=carBuyingRequest.getAiDecision();
    }

    public Date getMaxTimeToPay() {
        return maxTimeToPay;
    }

    public void setMaxTimeToPay(Date maxTimeToPay) {
        this.maxTimeToPay = maxTimeToPay;
    }

    public Date getMinTimeToPay() {
        return minTimeToPay;
    }

    public void setMinTimeToPay(Date minTimeToPay) {
        this.minTimeToPay = minTimeToPay;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getNumberOfRate() {
        return numberOfRate;
    }

    public void setNumberOfRate(Integer numberOfRate) {
        this.numberOfRate = numberOfRate;
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

    public CarBuyingRequest.Status getStatus() {
        return status;
    }

    public void setStatus(CarBuyingRequest.Status status) {
        this.status = status;
    }

    public Date getEmployeedFrom() {
        return employeedFrom;
    }

    public void setEmployeedFrom(Date employeedFrom) {
        this.employeedFrom = employeedFrom;
    }

    public Date getWorkingTo() {
        return workingTo;
    }

    public void setWorkingTo(Date workingTo) {
        this.workingTo = workingTo;
    }

    public CarBuyingRequest.RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(CarBuyingRequest.RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}