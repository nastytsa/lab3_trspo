package a3.orderserver.service;

import a3.orderserver.service.models.Dessert;
import javassist.NotFoundException;

import java.util.List;

public interface IDessertService {

    List<Dessert> findAll();

    Dessert save(Dessert dessertForSave);

    Dessert getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}
