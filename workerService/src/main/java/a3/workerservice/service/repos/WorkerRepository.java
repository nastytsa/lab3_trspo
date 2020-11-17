package a3.clientserver.service.repos;

import a3.clientserver.service.models.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, String> {
}
