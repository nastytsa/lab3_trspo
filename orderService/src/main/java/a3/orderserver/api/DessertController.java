package a3.orderserver.api;

import a3.orderserver.OrderserverApplication;
import a3.orderserver.service.IDessertService;
import a3.orderserver.service.models.Dessert;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/desserts")
@RequiredArgsConstructor
public final class DessertController {

    static final Logger log = LoggerFactory.getLogger(OrderserverApplication.class);

    @Autowired
    private IDessertService dessertService;

    @GetMapping
    public ResponseEntity<List<Dessert>> index(){return ResponseEntity.ok(dessertService.findAll());}

    @PostMapping
    public ResponseEntity<Dessert> create(@RequestBody DessertPayload payload){
        Dessert newDessert = new Dessert(payload.getName(),
                payload.getPrice());
        return ResponseEntity.ok(dessertService.save(newDessert));
    }

    @GetMapping("{dessertId}")
    public ResponseEntity<Dessert> show(@PathVariable String dessertId) throws NotFoundException {
        return ResponseEntity.ok(dessertService.getById(dessertId));
    }

    @DeleteMapping("{dessertId}")
    public ResponseEntity<Void> delete(@PathVariable String dessertId) throws NotFoundException{
        dessertService.deleteById(dessertId);
        return ResponseEntity.noContent().build();
    }
}
