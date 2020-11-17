package ds.confectionery_client.controllers;

import ds.confectionery_client.models.Client;
import ds.confectionery_client.models.Worker;
import ds.confectionery_client.payloads.WorkerPayload;
import ds.confectionery_client.request.Request;
import ds.confectionery_client.utils.Logging;
import ds.confectionery_client.utils.TestData;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Random;

public class WorkerTest {
    private final String endPoint = "http://172.17.0.2:8086/api/workers";

    private final Random rand = new Random();

    public void createWorker(int workersNumber) throws IOException {
        for (int i=0; i<workersNumber; i++){
            Request post = Request.builder()
                    .type(new HttpPost(endPoint))
                    .body(new WorkerPayload(TestData.getName(), TestData.getSurname(), TestData.getSalary()))
                    .response(Client.class).build();
            Logging.printObject(post.send(), "Creating a Worker");
        }
    }

    public Worker getRandomWorker() throws IOException {
        Request get = Request.builder()
                .type(new HttpGet(endPoint))
                .body(null)
                .response(Worker[].class).build();
        Worker[] workers = (Worker[]) get.send();
        return workers[rand.nextInt(workers.length)];
    }

    public void testService() throws IOException{
        System.out.println("Workers service testing".toUpperCase());
        createWorker(1);
    }
}
