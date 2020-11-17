package a3.clientserver.service;

import a3.clientserver.service.models.Worker;
import javassist.NotFoundException;

import java.util.List;

public interface IWorkerService {

    List<Worker> findAll();

    Worker save(Worker workerForSave);

    Worker getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}