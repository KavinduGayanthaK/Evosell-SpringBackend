package lk.ijse.gdse67.evosellspringbackend.dto.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lk.ijse.gdse67.evosellspringbackend.dto.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO implements OrderDetailsStatus {
    private String id;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerNic;
    private String itemName;
    private int orderQTY;
    private double unitPrice;
    private ItemDTO item;
    private OrderDTO order;
}
