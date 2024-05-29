package com.example.springboot.DTO;

import com.example.springboot.model.Car;
import com.example.springboot.model.CarBuyingRequest;

import java.util.Date;

public class CarDTO {
    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private Double price;
    private String imageUrl;
    private Car.CarType type;
    private Car.Condition condition;
    private Date dateAdded;
    private Boolean isFeatured;

    private CarBuyingRequestDTO carBuyingRequest;

    // Default constructor
    public CarDTO() {
    }

    // Constructor to convert Car entity to CarDTO
    public CarDTO(Car car) {
        this.id = car.getId();
        this.make = car.getMake();
        this.model = car.getModel();
        this.year = car.getYear();
        this.price = car.getPrice();
        this.imageUrl = car.getImageUrl();
        this.type = car.getType();
        this.condition = car.getCondition();
        this.dateAdded = car.getDateAdded();
        this.isFeatured = car.getIsFeatured();
        //this.carBuyingRequest.setAccepted(car.getCarBuyingRequest().getAccepted());
       // this.carBuyingRequest.setLoanAmount(car.getCarBuyingRequest().getLoanAmount());
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public CarBuyingRequestDTO getCarBuyingRequest() {
        return carBuyingRequest;
    }

    public void setCarBuyingRequest(CarBuyingRequestDTO carBuyingRequest) {
        this.carBuyingRequest = carBuyingRequest;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Car.CarType getType() {
        return type;
    }

    public void setType(Car.CarType type) {
        this.type = type;
    }

    public Car.Condition getCondition() {
        return condition;
    }

    public void setCondition(Car.Condition condition) {
        this.condition = condition;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }
}