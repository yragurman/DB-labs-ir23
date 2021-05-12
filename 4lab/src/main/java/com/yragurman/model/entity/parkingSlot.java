package com.yragurman.model.entity;


public class parkingSlot {
    private Integer id;

    private Integer slotNumber;

    private String isInvalidPlace;

    private Integer parkingPriceId;

    private String isReserved;

    private Integer timeCountInMinutes;

    public parkingSlot( Integer slotNumber, String isInvalidPlace, Integer parkingPriceId, String isReserved,Integer timeCountInMinutes) {
        this( -1, slotNumber, isInvalidPlace, parkingPriceId, isReserved, timeCountInMinutes);
    }

    public parkingSlot(Integer id, Integer slotNumber, String isInvalidPlace, Integer parkingPriceId, String isReserved,Integer timeCountInMinutes) {
        this.id = id;
        this.slotNumber=slotNumber;
        this.isInvalidPlace = isInvalidPlace;
        this.parkingPriceId = parkingPriceId;
        this.isReserved = isReserved;
        this.timeCountInMinutes = timeCountInMinutes;
    }


    public Integer getId() {
        return id;
    }

    public Integer getSlotNumber(){ return slotNumber; }

    public String getIsInvalidPlace() {return isInvalidPlace;}

    public Integer getParkingPriceId() {return parkingPriceId;}

    public String getIsReserved() {return isReserved;}

    public Integer getTimeCountInMinutes() {return timeCountInMinutes;}

    public void setId(Integer id){
        this.id = id;
    }

    public void setSlotNumber(Integer slotNumber){
        this.slotNumber = slotNumber;
    }

    public void setAddressId(String isInvalidPlace){
        this.isInvalidPlace = isInvalidPlace;
    }

    public void setParkingPriceId(Integer parkingPriceId){
        this.parkingPriceId = parkingPriceId;
    }

    public void setIsReserved(String isReserved){
        this.isReserved = isReserved;
    }

    public void setTimeCountInMinutes(Integer timeCountInMinutes){
        this.timeCountInMinutes = timeCountInMinutes;
    }

    @Override
    public String toString() {
        return "\n---------------\nid = " + id +
                ",\nslot number = " + slotNumber + ",\nis invalid place = " + isInvalidPlace +
                ",\nparking price id = " + parkingPriceId + ",\nis reserved = " + isReserved + ",\ntime count in minutes = " + timeCountInMinutes;
    }
}
