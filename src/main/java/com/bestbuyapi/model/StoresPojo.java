package com.bestbuyapi.model;

public class StoresPojo {

    private String name;
    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public static StoresPojo getStoresPojo(String name, String type, String address, String address2, String city, String state, String zip) {
        StoresPojo storesPojo =new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setName(address);
        storesPojo.setName(address2);
        storesPojo.setName(city);
        storesPojo.setName(state);
        storesPojo.setName(zip);
        return storesPojo;
    }

}

