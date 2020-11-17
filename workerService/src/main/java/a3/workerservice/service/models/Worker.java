package a3.clientserver.service.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "workers")

public class Worker {

    @Id
    private String id;
    private String name;
    private String surname;
    private double salary;

    public Worker(String name, String surname, double salary){
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.id = UUID.randomUUID().toString();
    }

    public Worker() {

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

    public double getSalary(){
        return salary;
    }
}