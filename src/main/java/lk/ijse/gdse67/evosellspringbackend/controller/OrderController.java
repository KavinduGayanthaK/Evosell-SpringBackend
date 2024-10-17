package lk.ijse.gdse67.evosellspringbackend.controller;

import lk.ijse.gdse67.evosellspringbackend.customStatusCode.SelectedOrderErrorStatus;
import lk.ijse.gdse67.evosellspringbackend.dto.OrderStatus;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDTO;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDetailsDTO;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.service.OrderService;
import lk.ijse.gdse67.evosellspringbackend.util.RegexPatterns;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/order")
public class OrderController {
    static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO){
        orderDTO.setOrderID(orderDTO.getOrderID());
        try{
            orderService.saveOrder(orderDTO);
            logger.error("Order Saved!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.error("Bad Request!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Internal Server Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") String orderId,@RequestBody OrderDTO orderDTO){
        try{
            orderService.updateOrder(orderId,orderDTO);
            logger.error("Update Order!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.error("Bad Request!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Internal Server Error!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") String orderId){
        try{
            if (!RegexPatterns.orderIdValidate(orderId).matches()) {
                logger.error("Bad Request!");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            orderService.deleteOrder(orderId);
            logger.error("No Content!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            logger.error("Not Found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            logger.error("Internal Server Error!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{orderId}")
    public OrderStatus getOrder(@PathVariable("orderId") String orderId){
        if (!RegexPatterns.orderIdValidate(orderId).matches()){
            logger.error("OrderId is Not valid!");
            return new SelectedOrderErrorStatus(1,"OrderId is Not valid!");
        }
        return orderService.getOrder(orderId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        List<OrderDTO> orderList = orderService.getAllOrder();
        try{
            if (orderList.isEmpty()) {
                logger.warn("No order found.");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                logger.info("Successfully retrieved all orders, total: {}", orderList.size());
                return new ResponseEntity<>(orderList, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
