package com.example.springboot.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    public enum CarType {
        SEDAN, SUV, TRUCK, COUPE, CONVERTIBLE, WAGON
    }

    public enum Condition {
        NEW, USED, CERTIFIED_PREOWNED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CarType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition", nullable = false)
    private Condition condition;

    @Column(name = "date_added")
    private Date dateAdded;

    @Column(name = "is_featured")
    private Boolean isFeatured;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private CarBuyingRequest carBuyingRequest;



    public Car() {
    }

    public Car(Integer id, String make, String model, Integer year, Double price, String imageUrl, CarType type, Condition condition) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.imageUrl = imageUrl;
        this.type = type;
        this.condition = condition;
        this.rents = new ArrayList<>();
        this.carBuyingRequest=null;

    }
    // Getters and setters


    public CarBuyingRequest getCarBuyingRequest() {
        return carBuyingRequest;
    }

    public void setCarBuyingRequest(CarBuyingRequest carBuyingRequest) {
        this.carBuyingRequest = carBuyingRequest;
    }

    public Integer getId() {
        return id;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
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

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
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