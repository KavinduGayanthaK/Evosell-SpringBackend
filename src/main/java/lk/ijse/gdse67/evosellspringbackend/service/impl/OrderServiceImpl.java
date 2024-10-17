package lk.ijse.gdse67.evosellspringbackend.service.impl;

import ch.qos.logback.core.status.ErrorStatus;
import lk.ijse.gdse67.evosellspringbackend.controller.OrderController;
import lk.ijse.gdse67.evosellspringbackend.customStatusCode.SelectedOrderErrorStatus;
import lk.ijse.gdse67.evosellspringbackend.dao.OrderDao;
import lk.ijse.gdse67.evosellspringbackend.dto.OrderStatus;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDTO;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDetailsDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.OrderEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.CustomerNotFoundException;
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

import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateOrder(String orderId, OrderDTO orderDTO) {
        logger.info("Attempting to update order with ID: {}", orderId);
        Optional<OrderEntity> tmpOrder = orderDao.findById(orderId);
        if (tmpOrder.isPresent()){
            tmpOrder.get().setDate(orderDTO.getDate());
            tmpOrder.get().setDiscountRate(orderDTO.getDiscountRate());
            tmpOrder.get().setDiscount(orderDTO.getDiscount());
            tmpOrder.get().setSubTotal(orderDTO.getSubTotal());
            tmpOrder.get().setBalance(orderDTO.getBalance());
            tmpOrder.get().setCustomer(mapping.toCustomerEntity(orderDTO.getCustomerId()));
            tmpOrder.get().setOrderDetailsList(mapping.toOrderEntityList(orderDTO.getOrderDetailDTO()));
            logger.info("Order with ID: {} has been updated successfully", orderId);
        }else {
            logger.warn("Order with ID: {} not found for update", orderId);
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        logger.info("Attempting to delete order with ID: {}", orderId);
        Optional<OrderEntity> tmpOrder = orderDao.findById(orderId);
        if (!tmpOrder.isPresent()){
            logger.error("Order with ID: {} not found for deletion", orderId);
            throw new CustomerNotFoundException("OrderId with " + orderId + "Not Found!");
        }else {
            orderDao.deleteById(orderId);
            logger.info("Order with ID: {} has been deleted successfully", orderId);
        }
    }

    @Override
    public OrderStatus getOrder(String orderId) {
        logger.info("Fetching order with ID: {}", orderId);
        if (orderDao.existsById(orderId)){
            logger.info("Order with ID: {} found", orderId);
            return mapping.toOrderDTO(orderDao.getReferenceById(orderId));
        }else {
            logger.warn("Order with ID: {} not found", orderId);
            return new SelectedOrderErrorStatus(2,"Selected order not found");
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        logger.info("Fetching all orders");
        List<OrderDTO> orders = mapping.toOrderList(orderDao.findAll());
        if (orders.isEmpty()) {
            logger.warn("No orders found");
        } else {
            logger.info("Number of orders found: {}", orders.size());
        }
        return orders;
    }
}
