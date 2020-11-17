package ds.confectionery_client.payloads;

import lombok.Data;

@Data
public class ErrorPayload {
    private String timestamp;
    private String message;
    private String details;
}
