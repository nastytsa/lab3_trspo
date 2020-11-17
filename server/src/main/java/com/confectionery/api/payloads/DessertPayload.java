package com.confectionery.api.payloads;

import com.confectionery.services.order_service.models.dessertName;

public class DessertPayload {

    private dessertName name;
    private double price;

    public dessertName getName(){return name;}

    public double getPrice(){return price;}
}
