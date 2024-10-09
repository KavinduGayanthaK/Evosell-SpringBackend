package lk.ijse.gdse67.evosellspringbackend.customStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomerErrorStatus {
    private int statusCode;
    private String statusMessage;
}
