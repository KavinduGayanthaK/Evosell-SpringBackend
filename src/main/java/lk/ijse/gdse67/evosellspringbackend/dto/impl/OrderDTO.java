package lk.ijse.gdse67.evosellspringbackend.dto.impl;

import lk.ijse.gdse67.evosellspringbackend.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements OrderStatus {
    private String orderID;
    private String date;
    private double discountRate;
    private double discount;
    private double subTotal;
    private double balance;
    private CustomerDTO customerId;
    private List<OrderDetailsDTO> orderDetailDTO;

}
