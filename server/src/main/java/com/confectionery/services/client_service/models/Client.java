package com.confectionery.services.client_service.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "clients")

public class Client {

    @Id
    private String id;
    private String name;
    private String surname;

    public Client(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID().toString();
    }

    public Client() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
