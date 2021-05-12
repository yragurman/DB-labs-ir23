package com.yragurman.model.entity;

import java.sql.Date;

public class parkingSlotReservation {
    private Integer id;

    private String bookingDate;

    private Integer customerId;

    private Integer parkingSlotId;

    private String isPaid;

    private String entryDate;

    private String exitDate;

    public parkingSlotReservation( String bookingDate, Integer customerId, Integer parkingSlotId, String isPaid, String entryDate, String exitDate) {
        this(-1, bookingDate, customerId, parkingSlotId, isPaid, entryDate, exitDate);
    }

    public parkingSlotReservation(Integer id, String bookingDate, Integer customerId, Integer parkingSlotId, String isPaid, String entryDate, String exitDate) {
        this.id = id;
        this.bookingDate=bookingDate;
        this.customerId = customerId;
        this.parkingSlotId = parkingSlotId;
        this.isPaid = isPaid;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
    }

    public Integer getId() {
        return id;
    }

    public String getBookingDate(){ return bookingDate; }

    public Integer getCustomerId() {return customerId;}

    public Integer getParkingSlotId() {return parkingSlotId;}

    public String getIsPaid() {return isPaid;}

    public String getEntryDate() {return entryDate;}

    public String getExitDate() {return exitDate;}

    public void setId(Integer id){
        this.id = id;
    }

    public void setBookingDate(String bookingDate){
        this.bookingDate = bookingDate;
    }

    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }

    public void setParkingSlotId(Integer parkingSlotId){
        this.parkingSlotId = parkingSlotId;
    }

    public void setIsPaid(String isPaid){
        this.isPaid = isPaid;
    }

    public void setEntryDate(String entryDate){
        this.entryDate = entryDate;
    }

    public void setExitDate(String exitDate){
        this.exitDate = exitDate;
    }

    @Override
    public String toString() {
        return "\n---------------\nid = " + id +
                ",\nbooking date = " + bookingDate + ",\ncustomer id = " + customerId +
                ",\nparking slot id = " + parkingSlotId + ",\nis paid = " + isPaid +
                ",\nentry date = " + entryDate +
                ",\nexit date = " + exitDate;
    }
}
