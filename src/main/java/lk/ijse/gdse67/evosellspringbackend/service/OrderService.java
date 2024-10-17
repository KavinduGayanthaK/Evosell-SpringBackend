package lk.ijse.gdse67.evosellspringbackend.service;

import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDTO;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDetailsDTO;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
}
