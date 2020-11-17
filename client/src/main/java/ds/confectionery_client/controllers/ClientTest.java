package ds.confectionery_client.controllers;

import ds.confectionery_client.models.Client;
import ds.confectionery_client.payloads.ClientPayload;
import ds.confectionery_client.request.Request;
import ds.confectionery_client.utils.TestData;
import ds.confectionery_client.utils.Logging;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class ClientTest {
    private final String endPoint = "http://172.17.0.2:8086/api/clients";

    private final Random rand = new Random();

    public void createClients(int clientsNumber) throws IOException {
        for (int i=0; i<clientsNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new ClientPayload(TestData.getName(), TestData.getSurname()))
                    .response(Client.class).build();
            Logging.printObject(post.send(), "Creating a Client");
        }
    }

    public Client getRandomClient() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Client[].class).build();
        Client[] clients = (Client[]) get.send();
        return clients[rand.nextInt(clients.length)];
    }


    public void testService() throws IOException{
        System.out.println("Client service testing".toUpperCase());
        createClients(2);
    }
}
