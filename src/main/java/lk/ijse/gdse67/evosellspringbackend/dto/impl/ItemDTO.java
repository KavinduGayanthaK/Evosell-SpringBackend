package lk.ijse.gdse67.evosellspringbackend.dto.impl;

import lk.ijse.gdse67.evosellspringbackend.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements ItemStatus {
    private String itemCode;
    private String name;
    private int quantityOnHand;
    private double price;
}
