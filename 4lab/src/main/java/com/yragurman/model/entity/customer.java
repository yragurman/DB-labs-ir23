package com.yragurman.model.entity;

public class customer {
    private Integer id;

    private String vehicleNumber;

    private String isRegularCustomer;

    private String contactNumber;

    public customer() {

    }

    public customer( String vehicleNumber, String isRegularCustomer, String contactNumber) {
        this( -1, vehicleNumber, isRegularCustomer, contactNumber);
    }

    public customer(Integer id, String vehicleNumber, String isRegularCustomer, String contactNumber) {
        this.id = id;
        this.vehicleNumber=vehicleNumber;
        this.isRegularCustomer = isRegularCustomer;
        this.contactNumber = contactNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public String getIsRegularCustomer(){
        return isRegularCustomer;
    }

    public String getContactNumber(){
        return  contactNumber;
    }


    public void setId(Integer id){
        this.id = id;
    }

    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }

    public void setIsRegularCustomer(String isRegularCustomer){
        this.isRegularCustomer = isRegularCustomer;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "\n---------------\nid = " + id +
                ",\nvehicle number = " + vehicleNumber + ",\nis regulary customer = " + isRegularCustomer +
                ",\ncontact number = " + contactNumber;
    }
}
