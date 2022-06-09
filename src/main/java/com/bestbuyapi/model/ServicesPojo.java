package com.bestbuyapi.model;

public class ServicesPojo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ServicesPojo getServicesPojo(String name) {
        ServicesPojo servicesPojo =new ServicesPojo();
        servicesPojo.setName(name);
        return servicesPojo;
    }
}

