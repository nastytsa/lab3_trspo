package ds.confectionery_client.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DessertPayload {
    private String name;
    private double price;
}
