package transaction.testbackend.model;

import lombok.Data;

@Data
public class PointScenario {
    String action;
    Integer Id;
    String Transaction_Type;
    Integer Amount_range_from;
    Integer Amount_range_to;
    Integer Point_per_unit;
    Integer Multiple_of;
}
