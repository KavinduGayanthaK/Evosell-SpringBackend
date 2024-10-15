package lk.ijse.gdse67.evosellspringbackend.customStatusCode;

import lk.ijse.gdse67.evosellspringbackend.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedItemErrorStatus implements ItemStatus {
    private int statusCode;
    private String statusMessage;
}
