package ds.confectionery_client;

import ds.confectionery_client.controllers.ClientTest;
import ds.confectionery_client.controllers.DessertTest;
import ds.confectionery_client.controllers.WorkerTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfectioneryClientApplication {

    public static void main(String[] args) {
        try{
            WorkerTest workerTest = new WorkerTest();
            DessertTest dessertTest = new DessertTest();
            ClientTest clientTest = new ClientTest();

            workerTest.testService();
            dessertTest.testService();
            clientTest.testService();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
