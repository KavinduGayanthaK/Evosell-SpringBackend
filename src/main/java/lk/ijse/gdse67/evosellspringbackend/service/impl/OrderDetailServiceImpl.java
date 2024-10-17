package lk.ijse.gdse67.evosellspringbackend.service.impl;

import lk.ijse.gdse67.evosellspringbackend.dao.OrderDao;
import lk.ijse.gdse67.evosellspringbackend.dao.OrderDetailsDao;
import lk.ijse.gdse67.evosellspringbackend.dto.impl.OrderDetailsDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.OrderDetailsEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.service.OrderDetailService;
import lk.ijse.gdse67.evosellspringbackend.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Autowired
    private Mapping mapping;
    static Logger logger = LoggerFactory.getLogger(OrderDetailServiceImpl.class);
    @Override
    public void saveOrderDetail(OrderDetailsDTO orderDetailDTO) {
        logger.info("Attempting to save order detail with ID: {}", orderDetailDTO.getId());
        OrderDetailsEntity orderDetailsEntity = orderDetailsDao.save(mapping.toOrderDetailEntity(orderDetailDTO));
        if (orderDetailsEntity==null){
            logger.error("Order detail with ID: {} could not be saved", orderDetailDTO.getId());
            throw new DataPersistException("Order detail not saved");
        } else {
            logger.info("Order detail with ID: {} has been saved successfully", orderDetailDTO.getId());
        }
    }
}
