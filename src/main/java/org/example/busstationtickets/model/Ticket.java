package org.example.busstationtickets.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate tripDate;
    private String tripName;
    private String busNumber;
    private Double price;
    private String seat;
    private LocalTime departureTime;

    public Ticket() {}

    public Ticket(LocalDate tripDate, String tripName, String busNumber,
                  Double price, String seat, LocalTime departureTime) {
        this.tripDate = tripDate;
        this.tripName = tripName;
        this.busNumber = busNumber;
        this.price = price;
        this.seat = seat;
        this.departureTime = departureTime;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public String getTripName() {
        return tripName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public Double getPrice() {
        return price;
    }

    public String getSeat() {
        return seat;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }
}

