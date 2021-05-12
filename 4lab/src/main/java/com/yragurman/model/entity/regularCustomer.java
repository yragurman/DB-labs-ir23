package com.yragurman.model.entity;

public class regularCustomer {
    private Integer id;

    private Integer customerId;

    private String purchaseDate;

    private String startDate;

    private Integer durationInDay;

    private Integer cost;

    public regularCustomer( Integer customerId, String purchaseDate, String startDate, Integer durationInDay, Integer cost) {
        this(-1, customerId, purchaseDate, startDate, durationInDay, cost);
    }

    public regularCustomer(Integer id, Integer customerId, String purchaseDate, String startDate, Integer durationInDay, Integer cost) {
        this.id = id;
        this.customerId=customerId;
        this.purchaseDate = purchaseDate;
        this.startDate = startDate;
        this.durationInDay = durationInDay;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId(){ return customerId; }

    public String getPurchaseDate() {return purchaseDate;}

    public String getStartDate() {return startDate;}

    public Integer getDurationInDay () {return durationInDay;}

    public Integer getCost() {return cost;}

    public void setId(Integer id){
        this.id = id;
    }

    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }

    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public void setDurationInDay(Integer durationInDay){
        this.durationInDay = durationInDay;
    }

    public void setCost(Integer cost){
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "\n---------------\nid = " + id +
                ",\ncustomer id = " + customerId + ",\npurchase date = " + purchaseDate +
                ",\nstart date = " + startDate + ",\nduration in day = " + durationInDay +
                ",\ncost = " + cost;
    }
}
