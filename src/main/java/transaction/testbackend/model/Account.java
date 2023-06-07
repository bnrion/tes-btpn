package transaction.testbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Account {
    @JsonProperty("action")
    private String Action;
    @JsonProperty("id")
    private Integer Id;
    @JsonProperty("name")
    private String Name;
}
