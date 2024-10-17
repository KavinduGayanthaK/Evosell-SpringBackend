package lk.ijse.gdse67.evosellspringbackend.customStatusCode;

import lk.ijse.gdse67.evosellspringbackend.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedOrderErrorStatus implements OrderStatus {
    private int statusCode;
    private String statusMessage;
}
