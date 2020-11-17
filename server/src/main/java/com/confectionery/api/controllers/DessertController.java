package com.confectionery.api.controllers;

import com.confectionery.services.order_service.models.Dessert;
import com.example.demo.classes.request.RequestState;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/desserts")
@RequiredArgsConstructor
public final class DessertController {

    private final RestTemplate template = new RestTemplate();
    private final String address = "http://dessertsService:8084/api/dessert";

    @GetMapping
    public ResponseEntity<List<Dessert>> index(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);
        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());

    }

    @PostMapping
    public ResponseEntity<Dessert> create(@RequestBody DessertPayload payload){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("payload", payload);

        HttpEntity<Dessert> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Dessert.class);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("{dessertId}")
    public ResponseEntity<Dessert> show(@PathVariable String dessertId) throws NotFoundException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("dessertId", dessertId);

        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping("{dessertId}")
    public ResponseEntity<Void> delete(@PathVariable String dessertId) throws NotFoundException{
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("dessertId", dessertId);

        HttpEntity<Boolean> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Boolean.class);
        return ResponseEntity.ok(response.getBody());
    }
}


