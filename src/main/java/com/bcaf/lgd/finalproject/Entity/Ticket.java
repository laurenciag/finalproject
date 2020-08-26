package com.bcaf.lgd.finalproject.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    public String id;
    public int seatNumber,cancellable;
    public Date journeyDate;
    private String tripSchedule, passenger;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getCancellable() {
        return cancellable;
    }

    public void setCancellable(int cancellable) {
        this.cancellable = cancellable;
    }

    public String getTripSchedule() {
        return tripSchedule;
    }

    public void setTripSchedule(String tripSchedule) {
        this.tripSchedule = tripSchedule;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }
}
