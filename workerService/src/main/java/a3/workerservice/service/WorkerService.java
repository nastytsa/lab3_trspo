package a3.clientserver.service;

import a3.clientserver.service.IWorkerService;
import a3.clientserver.service.models.Worker;
import a3.clientserver.service.repos.WorkerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class WorkerService implements IWorkerService {

    @Autowired
    private WorkerRepository repository;

    @Override
    public List<Worker> findAll() {
        return (List<Worker>) repository.findAll();
    }

    @Override
    public Worker save(Worker workerForSave) {
        return repository.save(workerForSave);
    }

    @Override
    public Worker getById(String id) throws NotFoundException {
        Optional<Worker> tempWorker = repository.findById(id);
        if (tempWorker.isPresent())
            return repository.findById(id).get();
        else
            throw new NotFoundException(String.format("Worker with id %s does not exist", id));
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        repository.delete(getById(id));
    }
}