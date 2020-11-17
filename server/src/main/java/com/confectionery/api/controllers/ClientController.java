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
@RequestMapping("api/clients")
@RequiredArgsConstructor
public final class ClientController {

    private final RestTemplate template = new RestTemplate();
    private final String address = "http://clientService:8085/api/clients";

    @GetMapping
    public ResponseEntity<List<Client>> index() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);
        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody ClientPayload payload) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("payload", payload);

        HttpEntity<Client> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Client.class);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("{clientId}")
    public ResponseEntity<Client> show(@PathVariable String clientId) throws NotFoundException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("clientId", clientId);

        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> delete(@PathVariable String clientId) throws NotFoundException {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("clientId", clientId);

        HttpEntity<Boolean> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Boolean.class);
        return ResponseEntity.ok(response.getBody());
    }
}