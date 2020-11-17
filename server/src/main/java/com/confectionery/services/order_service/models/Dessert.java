package com.confectionery.services.order_service.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@EnableAutoConfiguration
@Entity
@Table(name = "desserts")

public class Dessert {
    @Id
    private String dessert_id;
    private dessertName name;
    private double price;

    public Dessert(dessertName name, double price) {
        this.price = price;
        this.name = name;
        this.dessert_id = UUID.randomUUID().toString();
    }

    public Dessert(){
    }

    public dessertName getName(){
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getId(){
        return this.dessert_id;
    }
}
