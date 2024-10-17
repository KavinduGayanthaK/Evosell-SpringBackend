package lk.ijse.gdse67.evosellspringbackend.service;

import lk.ijse.gdse67.evosellspringbackend.dto.OrderStatus;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDTO;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDetailsDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    void updateOrder(String orderId,OrderDTO orderDTO);
    void deleteOrder(String orderId);
    OrderStatus getOrder(String orderId);
    List<OrderDTO> getAllOrder();
}
