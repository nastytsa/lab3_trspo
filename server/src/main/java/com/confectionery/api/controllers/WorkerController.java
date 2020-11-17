package com.confectionery.api.controllers;

import com.confectionery.services.client_service.models.Client;
import com.example.demo.classes.request.RequestState;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("api/workers")
@RequiredArgsConstructor
public final class WorkerController {

    private final RestTemplate template = new RestTemplate();
    private final String address = "http://workerService:8083/api/workers";

    @GetMapping
    public ResponseEntity<List<Worker>> index() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);
        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @PostMapping
    public ResponseEntity<Worker> create(@RequestBody WorkerPayload payload) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("payload", payload);

        HttpEntity<Worker> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Worker.class);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("{workerId}")
    public ResponseEntity<Worker> show(@PathVariable String workerId) throws NotFoundException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("workerId", workerId);

        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping("{workerId}")
    public ResponseEntity<Void> delete(@PathVariable String workerId) throws NotFoundException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("workerId", workerId);

        HttpEntity<Boolean> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Boolean.class);
        return ResponseEntity.ok(response.getBody());
    }
}
