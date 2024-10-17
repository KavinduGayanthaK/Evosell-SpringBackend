package lk.ijse.gdse67.evosellspringbackend.service.impl;

import lk.ijse.gdse67.evosellspringbackend.controller.OrderController;
import lk.ijse.gdse67.evosellspringbackend.dao.OrderDao;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDTO;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDetailsDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.OrderEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.service.OrderDetailService;
import lk.ijse.gdse67.evosellspringbackend.service.OrderService;
import lk.ijse.gdse67.evosellspringbackend.util.AppUtil;
import lk.ijse.gdse67.evosellspringbackend.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    Mapping mapping;

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailService orderDetailService;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        logger.info("Attempting to save order with ID: {}", orderDTO.getOrderID());
        OrderEntity order = orderDao.save(mapping.toOrderEntity(orderDTO));
        if (order == null) {
            logger.error("Order with ID: {} could not be saved", orderDTO.getOrderID());
            throw new DataPersistException("Order Note Saved");
        } else {
            logger.info("Order with ID: {} has been saved successfully", orderDTO.getOrderID());
            for (OrderDetailsDTO orderDetailDTO : orderDTO.getOrderDetailDTO()) {
                orderDetailDTO.setId(AppUtil.generateOrderDetailId());
                orderDetailDTO.setOrder(orderDTO);
                orderDetailService.saveOrderDetail(new OrderDetailsDTO(
                        orderDetailDTO.getId(),
                        orderDetailDTO.getDate(),
                        orderDetailDTO.getCustomerId(),
                        orderDetailDTO.getCustomerName(),
                        orderDetailDTO.getCustomerAddress(),
                        orderDetailDTO.getCustomerEmail(),
                        orderDetailDTO.getCustomerNic(),
                        orderDetailDTO.getItemName(),
                        orderDetailDTO.getOrderQTY(),
                        orderDetailDTO.getUnitPrice(),
                        orderDetailDTO.getItem(),
                        orderDetailDTO.getOrder()
                ));
                logger.info("Order detail for order ID: {} saved successfully", orderDTO.getOrderID());
            }
        }
    }
}
