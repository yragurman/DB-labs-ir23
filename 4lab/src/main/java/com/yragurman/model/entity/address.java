package com.yragurman.model.entity;

public class address {

    private Integer id;

    private String country;

    private String city;

    private String address_name;

    private  Integer postIndex;

    public address() {

    }

    public address( String country, String city, String address_name, Integer postIndex) {
        this(-1,  country, city, address_name, postIndex);
    }

    public address(Integer id, String country, String city, String address_name, Integer postIndex) {
        this.id = id;
        this.country=country;
        this.city = city;
        this.address_name = address_name;
        this.postIndex = postIndex;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry(){
        return country;
    }

    public String getCity(){
        return city;
    }

    public String getAddressName(){
        return  address_name;
    }

    public Integer getPostIndex(){
        return postIndex;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setAddressName(String addressName){
        this.address_name = address_name;
    }

    public void setPostIndex(Integer postIndex){
        this.postIndex = postIndex;
    }
    @Override
    public String toString() {
        return "\n---------------\nid=" + id +
                ",\ncountry=" + country + ",\ncity=" + city + ",\naddress=" + address_name +
                ",\npost index=" + postIndex;
    }
}
