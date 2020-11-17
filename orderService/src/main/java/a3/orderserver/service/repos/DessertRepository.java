package a3.orderserver.service.repos;

import a3.orderserver.service.models.Dessert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertRepository extends CrudRepository<Dessert, String> {
}
