package com.example.springboot.model;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "buyingRequest")
public class CarBuyingRequest {

    public enum Status {
        EMPLOYED, UNEMPLOYED, EMPLOYEDUNSPECIFIED
    }

    public enum RequestStatus {
        ACCEPTED, REJECTED, PENDING
    }

    public enum Decision {
        Approved_By_System,Not_Approved_By_Sustem,Waiting
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


    @OneToOne
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

    @Column(name = "requestStatus", nullable = true)
    private CarBuyingRequest.RequestStatus requestStatus;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "maxTimeToPay", nullable = false)
    private Date maxTimeToPay;

    @Column(name = "minTimeToPay", nullable = false)
    private Date minTimeToPay;


    @Column(name = "aiDecision", nullable = false)
    private Integer aiDecision;

    private boolean decisionMade;

    @Column(name = "stableIncome", nullable = false)
    private boolean stableIncome;

    public boolean isStableIncome() {
        return stableIncome;
    }

    public void setStableIncome(boolean stableIncome) {
        this.stableIncome = stableIncome;
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


    public boolean isDecisionMade() {
        return decisionMade;
    }

    public void setDecisionMade(boolean decisionMade) {
        this.decisionMade = decisionMade;
    }

    public Integer getAiDecision() {
        return aiDecision;
    }

    public void setAiDecision(Integer aiDecision) {
        this.aiDecision = aiDecision;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
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

    public CarBuyingRequest() {

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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


}
