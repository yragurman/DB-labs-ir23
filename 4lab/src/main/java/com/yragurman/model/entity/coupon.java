package com.yragurman.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class coupon {
    java.util.Date date = new Date();
    Object param = new java.sql.Timestamp(date.getTime());

    private Integer id;

    private Integer customer_id;

    private String entryDate;

    private String exitDate;

    private Integer parkingSlotId;


    public coupon() {

    }

    public coupon( Integer customer_id, String entryDate, String exitDate, Integer parkingSlotId) {
        this(-1,  customer_id, entryDate, exitDate, parkingSlotId);
    }

    public coupon(Integer id, Integer customer_id, String entryDate, String exitDate, Integer parkingSlotId) {
        this.id = id;
        this.customer_id = customer_id;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.parkingSlotId = parkingSlotId;
    }

    public Integer getId() { return id; }

    public Integer getCustomerId(){
        return customer_id;
    }

    public String getEntryDate(){
        return entryDate;
    }

    public String getExitDate(){
        return  exitDate;
    }

    public Integer getParkingSlotId(){
        return parkingSlotId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setCustomerId(Integer customer_id){
        this.customer_id = customer_id;
    }

    public void setEntryDate(String entryDate){
        this.entryDate = entryDate;
    }

    public void setExitDate(String exitDate){
        this.exitDate = exitDate;
    }

    public void setParkingSlotId(Integer postIndex){ this.parkingSlotId = parkingSlotId; }
    @Override
    public String toString() {
        return "\n---------------\nid = " + id +
                ",\ncustomer id = " + customer_id + ",\nentry date = " + entryDate + ",\nexit date = " + exitDate +
                ",\nparking slot id = " + parkingSlotId;
    }
}
