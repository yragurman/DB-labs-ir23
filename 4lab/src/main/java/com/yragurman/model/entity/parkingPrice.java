package com.yragurman.model.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class parkingPrice {

    private Integer id;

    private BigDecimal morningPrice;

    private BigDecimal middayPrice;

    private BigDecimal eveningPrice;

    private BigDecimal allDayPrice;

    public parkingPrice( BigDecimal morningPrice, BigDecimal middayPrice, BigDecimal eveningPrice, BigDecimal allDayPrice) {
        this( -1, morningPrice, middayPrice, eveningPrice, allDayPrice);
    }

    public parkingPrice(Integer id, BigDecimal morningPrice, BigDecimal middayPrice, BigDecimal eveningPrice, BigDecimal allDayPrice) {
        this.id = id;
        this.morningPrice=morningPrice;
        this.middayPrice = middayPrice;
        this.eveningPrice = eveningPrice;
        this.allDayPrice = allDayPrice;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getMorningPrice(){ return morningPrice; }

    public BigDecimal getMiddayPrice() {return middayPrice;}

    public BigDecimal getEveningPrice() {return eveningPrice;}

    public BigDecimal getAllDayPrice() {return allDayPrice;}


    public void setId(Integer id){
        this.id = id;
    }

    public void setMorningPrice(BigDecimal morningPrice){
        this.morningPrice = morningPrice;
    }

    public void setAddressId(BigDecimal middayPrice){
        this.middayPrice = middayPrice;
    }

    public void setCustomerId(BigDecimal eveningPrice){
        this.eveningPrice = eveningPrice;
    }

    public void setParkingSlotId(BigDecimal allDayPrice){
        this.allDayPrice = allDayPrice;
    }

    @Override
    public String toString() {
        return "\n---------------\nid = " + id +
                ",\nmorning price = " + morningPrice + ",\nmidday price = " + middayPrice +
                ",\nevening price = " + eveningPrice + ",\nevening price = " + eveningPrice;
    }
}
