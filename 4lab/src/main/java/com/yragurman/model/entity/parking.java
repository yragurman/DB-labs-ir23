package com.yragurman.model.entity;

public class parking {
    private Integer id;

    private String tradeNetwork;

    private Integer addressId;

    private Integer customerId;

    private Integer parkingSlotId;

    public parking( String tradeNetwork, Integer addressId, Integer customerId, Integer parkingSlotId) {
        this( -1, tradeNetwork, addressId, customerId, parkingSlotId);
    }

    public parking(Integer id, String tradeNetwork, Integer addressId, Integer customerId, Integer parkingSlotId) {
        this.id = id;
        this.tradeNetwork=tradeNetwork;
        this.addressId = addressId;
        this.customerId = customerId;
        this.parkingSlotId = parkingSlotId;
    }

    public Integer getId() {
        return id;
    }

    public String getTradeNetwork(){
        return tradeNetwork;
    }

    public Integer getAddressId() {return addressId;}

    public Integer getCustomerId(){
        return customerId;
    }

    public Integer getParkingSlotId(){
        return  parkingSlotId;
    }


    public void setId(Integer id){
        this.id = id;
    }

    public void setTradeNetwork(String tradeNetwork){
        this.tradeNetwork = tradeNetwork;
    }

    public void setAddressId(Integer addressId){
        this.addressId = addressId;
    }

    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }

    public void setParkingSlotId(Integer parkingSlotId){
        this.parkingSlotId = parkingSlotId;
    }

    @Override
    public String toString() {
        return "\n---------------\nid = " + id +
                ",\ntrade network = " + tradeNetwork + ",\naddress Id = " + addressId +
                ",\ncustomer Id = " + customerId + ",\nparking Slot Id = " + parkingSlotId;
    }

}
