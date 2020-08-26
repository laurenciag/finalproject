package com.bcaf.lgd.finalproject.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class TripSchedule {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    public String id;
    public int availableSeat;
    public Date tripDate;
    private String tripDetail;
    @ElementCollection
    public Set<Long> ticketsSold = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getTripDetail() {
        return tripDetail;
    }

    public void setTripDetail(String tripDetail) {
        this.tripDetail = tripDetail;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public Set<Long> getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(Set<Long> ticketsSold) {
        this.ticketsSold = ticketsSold;
    }
}
