package transaction.testbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FilterTransaction {
    @JsonProperty("account_id")
    private int accountID;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
}
