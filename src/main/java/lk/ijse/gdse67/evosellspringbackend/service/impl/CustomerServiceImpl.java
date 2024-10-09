package lk.ijse.gdse67.evosellspringbackend.service.impl;

import lk.ijse.gdse67.evosellspringbackend.dao.CustomerDao;
import lk.ijse.gdse67.evosellspringbackend.dto.CustomerDTO;
import lk.ijse.gdse67.evosellspringbackend.entity.impl.CustomerEntity;
import lk.ijse.gdse67.evosellspringbackend.exception.DataPersistException;
import lk.ijse.gdse67.evosellspringbackend.service.CustomerService;
import lk.ijse.gdse67.evosellspringbackend.util.AppUtil;
import lk.ijse.gdse67.evosellspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Autowired
    Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
       customerDTO.setId(AppUtil.generateCustomerId());
       CustomerEntity saveCustomer = customerDao.save(mapping.toCustomerEntity(customerDTO));
       if (saveCustomer == null) {
           throw new DataPersistException("Customer not saved");
       }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapping.toCustomerList(customerDao.findAll());
    }
}
