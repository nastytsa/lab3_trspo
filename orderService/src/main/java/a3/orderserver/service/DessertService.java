package a3.orderserver.service;

import a3.orderserver.service.models.Dessert;
import a3.orderserver.service.repos.DessertRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DessertService implements IDessertService {

    @Autowired
    private DessertRepository repository;

    @Override
    public List<Dessert> findAll() {
        return (List<Dessert>) repository.findAll();
    }

    @Override
    public Dessert save(Dessert dessertForSave) {
        return repository.save(dessertForSave);
    }

    @Override
    public Dessert getById(String id) throws NotFoundException {
        Optional<Dessert> tempDessert = repository.findById(id);
        if (tempDessert.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Dessert with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}
