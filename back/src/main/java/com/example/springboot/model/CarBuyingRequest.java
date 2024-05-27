package com.example.springboot.model;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "buyingRequest")
public class CarBuyingRequest {

    public enum Status {
        EMPLOYED, UNEMPLOYED, EMPLOYEDUNSPECIFIED
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    @Column(name = " monthlyIncome", nullable = false)
    private Double  monthlyIncome;

    @Column(name = "loanAmount", nullable = false)
    private Double loanAmount;

    @Column(name = "numberOfRate", nullable = false)
    private Integer numberOfRate;


    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CarBuyingRequest.Status status;

    @Column(name = "employeedFrom", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date employeedFrom;

    @Column(name = "workingTo", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date workingTo;

    @Column(name = "is_Accepted", nullable = true)
    private Boolean isAccepted;


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

    public CarBuyingRequest() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }
}