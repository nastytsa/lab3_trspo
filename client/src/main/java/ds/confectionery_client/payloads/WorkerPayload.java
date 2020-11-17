package ds.confectionery_client.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkerPayload {
    private String name;
    private String surname;
    private double salary;
}
