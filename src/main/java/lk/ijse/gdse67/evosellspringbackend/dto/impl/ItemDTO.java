package lk.ijse.gdse67.evosellspringbackend.dto.impl;

import lk.ijse.gdse67.evosellspringbackend.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements ItemStatus {
    private String itemCode;
    private String itemName;
    private int QTYOnHand;
    private double unitPrice;
    private List<OrderDetailsDTO> orderList;
}
