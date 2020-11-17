package ds.confectionery_client.controllers;

import ds.confectionery_client.models.Client;
import ds.confectionery_client.models.Dessert;
import ds.confectionery_client.payloads.DessertPayload;
import ds.confectionery_client.request.Request;
import ds.confectionery_client.utils.Logging;
import ds.confectionery_client.utils.TestData;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class DessertTest {
    private final String endPoint = "http://172.17.0.2:8086/api/desserts";
    private final Random rand = new Random();

    public void createDessert(int dessertNumber) throws IOException {
        for (int i=0; i<dessertNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new DessertPayload(TestData.getDessert(), TestData.getPrice()))
                    .response(Client.class).build();
            Logging.printObject(post.send(), "Creating a dessert");
        }
    }

    public Dessert getRandomDessert() throws IOException{
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Dessert[].class).build();
        Dessert[] desserts = (Dessert[]) get.send();
        return desserts[rand.nextInt(desserts.length)];
    }

    public void testService() throws IOException{
        System.out.println("Dessert service testing".toUpperCase());
        createDessert(2);
    }

}
